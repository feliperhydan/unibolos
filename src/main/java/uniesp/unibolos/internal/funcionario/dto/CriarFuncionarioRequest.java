package uniesp.unibolos.internal.funcionario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CriarFuncionarioRequest(
        @NotBlank
        String nome,

        @NotBlank
        String cargo,

        @Email
        @NotBlank
        String email,

        @NotBlank
        String telefone,

        @NotNull
        Boolean ativo,

        @NotNull
        LocalDateTime admitido_em
) {
}