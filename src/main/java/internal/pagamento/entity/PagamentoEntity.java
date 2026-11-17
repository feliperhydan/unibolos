package internal.pagamento.entity;

import internal.encomenda.entity.EncomendaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "pagamentos")
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pagamento;


    @ManyToOne
    @JoinColumn(name = "id_encomenda")
    private EncomendaEntity encomenda;

    @Column(nullable = false, precision = 10, scale = 2)
    private Float valor;

    @Column(nullable = false)
    private LocalDateTime data_pagamento;

    @Column(nullable = false, length = 30)
    private String forma_pagamento;

    public PagamentoEntity(Float valor, String forma_pagamento) {
        this.valor = valor;
        this.forma_pagamento = forma_pagamento;
    }

    public void alterarValor(Float valor) {
        this.valor = valor;
    }

    public void associarEncomenda(EncomendaEntity encomenda) {
        this.encomenda = encomenda;
    }
}
