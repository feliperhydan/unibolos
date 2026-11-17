package uniesp.unibolos.internal.historico.entity;


import uniesp.unibolos.internal.encomenda.entity.EncomendaEntity;
import uniesp.unibolos.internal.funcionario.entity.FuncionarioEntity;
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
    private Long idHistorico;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_encomenda", nullable = false)
    private EncomendaEntity encomenda;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_funcionario", nullable = false)
    private FuncionarioEntity funcionario;

    @Column(nullable = false)
    private String statusAnterior;

    @Column(nullable = false)
    private String statusNovo;

    @Column(length = 300)
    private String observacao;
    
    @Column(nullable = false)
    private LocalDateTime registradoEm;

    public HistoricoEntity(EncomendaEntity encomenda, FuncionarioEntity funcionario, String statusAnterior,
                           String statusNovo, String observacao) {
        this.encomenda = encomenda;
        this.funcionario = funcionario;
        this.statusAnterior = statusAnterior;
        this.statusNovo = statusNovo;
        this.observacao = observacao;
        this.registradoEm = LocalDateTime.now();
    }

}
