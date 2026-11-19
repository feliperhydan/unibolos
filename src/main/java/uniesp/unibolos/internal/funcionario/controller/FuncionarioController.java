package uniesp.unibolos.internal.funcionario.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uniesp.unibolos.internal.funcionario.dto.CriarFuncionarioRequest;
import uniesp.unibolos.internal.funcionario.dto.CriarFuncionarioResponse;
import uniesp.unibolos.internal.funcionario.service.FuncionarioService;

@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<CriarFuncionarioResponse> criar(@Valid @RequestBody CriarFuncionarioRequest request) {
        CriarFuncionarioResponse response = funcionarioService.criarFuncionario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
