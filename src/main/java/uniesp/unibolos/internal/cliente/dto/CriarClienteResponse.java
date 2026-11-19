package uniesp.unibolos.internal.cliente.dto;

import java.time.LocalDateTime;

public record CriarClienteResponse(
        String nome,
        String cpf,
        String telefone,
        String email,
        String endereco,
        LocalDateTime criadoEm) {
}
