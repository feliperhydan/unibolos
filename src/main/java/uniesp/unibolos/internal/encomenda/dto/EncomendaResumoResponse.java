
package uniesp.unibolos.internal.encomenda.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record EncomendaResumoResponse(

        Long id_encomenda,
        Long id_cliente,
        Long id_funcionario,
        String descricao,
        int quantidade,
        BigDecimal valorTotal,
        LocalDateTime dataPedido,
        LocalDate dataEntrega,
        String status,
        String observacoes

) {
}
