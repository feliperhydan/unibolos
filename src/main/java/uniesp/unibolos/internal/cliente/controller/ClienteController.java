package uniesp.unibolos.internal.cliente.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniesp.unibolos.internal.cliente.dto.ClienteResumoResponse;
import uniesp.unibolos.internal.cliente.dto.CriarClienteRequest;
import uniesp.unibolos.internal.cliente.dto.CriarClienteResponse;
import uniesp.unibolos.internal.cliente.service.ClienteService;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ClienteResumoResponse>> listar() {
        List<ClienteResumoResponse> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }
}
