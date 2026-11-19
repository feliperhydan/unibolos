package uniesp.unibolos.internal.cliente.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

public record CriarClienteRequest(
        @NotNull
        String nome,

        @NotBlank
        @CPF
        String cpf,

        @NotBlank
        @Pattern(regexp = "^\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}$",
                message = "Telefone inválido")
        String telefone,

        @Email
        String email,

        @NotBlank
        @Size(max = 255)
        String endereco) {
}
