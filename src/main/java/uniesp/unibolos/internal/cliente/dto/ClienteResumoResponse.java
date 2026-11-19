package uniesp.unibolos.internal.cliente.dto;

import java.time.LocalDateTime;

public record ClienteResumoResponse(
        Long id,
        String nome,
        String cpf,
        String telefone,
        String email,
        String endereco,
        LocalDateTime criadoEm,
        boolean ativo
) {
}
