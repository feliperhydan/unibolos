
package uniesp.unibolos.internal.encomenda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CriarEncomendaRequest(

        @NotNull
        Long id_cliente,

        @NotNull
        Long id_funcionario,

        @NotBlank
        String descricao,

        @Positive
        int quantidade,

        @NotNull
        @Positive
        BigDecimal valorTotal,

        @NotNull
        LocalDate dataEntrega,

        @NotBlank
        String status,

        String observacoes

) {
}
