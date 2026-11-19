
package uniesp.unibolos.internal.encomenda.controller;

import uniesp.unibolos.internal.encomenda.dto.CriarEncomendaRequest;
import uniesp.unibolos.internal.encomenda.dto.EncomendaResumoResponse;
import uniesp.unibolos.internal.encomenda.service.EncomendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.web.PageableDefault;

@RestController
@RequestMapping("encomendas")
@RequiredArgsConstructor
public class EncomendaController {

    private final EncomendaService encomendaService;

    @PostMapping
    public ResponseEntity<EncomendaResumoResponse> criar(
            @Valid @RequestBody CriarEncomendaRequest request) {
        EncomendaResumoResponse response = encomendaService.criarEncomenda(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncomendaResumoResponse> buscarPorId(@PathVariable Long id) {
        EncomendaResumoResponse response = encomendaService.buscarEncomendaPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<EncomendaResumoResponse>> listarTodos(
            @PageableDefault(size = 10) Pageable pageable) {
        Page<EncomendaResumoResponse> page = encomendaService.listarTodos(pageable);
        return ResponseEntity.ok(page);
    }
}
