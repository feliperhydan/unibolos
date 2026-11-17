package internal.historico.entity;


import internal.encomenda.entity.EncomendaEntity;
import internal.funcionario.entity.FuncionarioEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "historicos")
public class HistoricoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_historico;


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_encomenda")
    private EncomendaEntity encomenda;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_funcionario")
    private FuncionarioEntity funcionario;

    @Column(nullable = false)
    private String status_anterior;

    @Column(nullable = false)
    private String status_novo;

    @Column(nullable = true)
    private String observacao;

    @Column(nullable = true)
    private LocalDateTime registrado_em;

    public HistoricoEntity(String status_anterior, String status_novo, String observacao) {
        this.status_anterior = status_anterior;
        this.status_novo = status_novo;
        this.observacao = observacao;
    }

    public void alterarStatus(String status_novo)  {
        this.status_novo = status_novo;
    }

    public void associarEncomenda(EncomendaEntity encomenda) {
        this.encomenda = encomenda;
    }
}
