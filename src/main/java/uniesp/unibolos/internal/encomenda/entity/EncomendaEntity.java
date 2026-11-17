package uniesp.unibolos.internal.encomenda.entity;


import uniesp.unibolos.internal.cliente.entity.ClienteEntity;
import uniesp.unibolos.internal.funcionario.entity.FuncionarioEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uniesp.unibolos.internal.historico.entity.HistoricoEntity;
import uniesp.unibolos.internal.pagamento.entity.PagamentoEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "encomendas")
public class EncomendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_encomenda;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_funcionario", nullable = false)
    private FuncionarioEntity funcionario;

    @OneToMany(mappedBy = "encomenda")
    private List<PagamentoEntity> pagamentos;

    @OneToMany(mappedBy = "encomenda")
    private List<HistoricoEntity> historicos;


    @Column(nullable = false, length = 300, columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(nullable = false)
    private LocalDateTime dataPedido;

    @Column(nullable = false)
    private LocalDateTime dataEntrega;

    @Column(nullable = false, length = 30)
    private String status;

    @Column(length = 300)
    private String observacoes;



    public EncomendaEntity(String descricao, int quantidade, BigDecimal valor_total, String status, String observacoes) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorTotal = valor_total;
        this.status = status;
        this.observacoes = observacoes;
        this.dataPedido = LocalDateTime.now();
    }

    public void associarCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public void associarFuncionario(FuncionarioEntity funcionario) {
        this.funcionario = funcionario;
    }

    public void alterarDados(String descricao, int quantidade, BigDecimal valor_total, String status, String observacoes) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorTotal = valor_total;
        this.status = status;
        this.observacoes = observacoes;
    }

}
