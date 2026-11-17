package uniesp.unibolos.internal.pagamento.entity;

import uniesp.unibolos.internal.encomenda.entity.EncomendaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "pagamentos")
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_encomenda")
    private EncomendaEntity encomenda;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDateTime dataPagamento;

    @Column(nullable = false, length = 30)
    private String formaPagamento;

    public PagamentoEntity(BigDecimal valor, String formaPagamento) {
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.dataPagamento = LocalDateTime.now();
    }

    public void alterarValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void associarEncomenda(EncomendaEntity encomenda) { this.encomenda = encomenda; }

}
