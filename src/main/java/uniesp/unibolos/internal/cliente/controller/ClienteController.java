package uniesp.unibolos.internal.cliente.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uniesp.unibolos.internal.cliente.dto.CriarClienteRequest;
import uniesp.unibolos.internal.cliente.dto.CriarClienteResponse;
import uniesp.unibolos.internal.cliente.service.ClienteService;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;


    @PostMapping
    public ResponseEntity<CriarClienteResponse> criar(@Valid @RequestBody CriarClienteRequest request) {
        CriarClienteResponse response = clienteService.criarCliente(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
