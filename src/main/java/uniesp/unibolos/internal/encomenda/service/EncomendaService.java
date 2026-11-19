
package uniesp.unibolos.internal.encomenda.service;

import uniesp.unibolos.internal.encomenda.dto.CriarEncomendaRequest;
import uniesp.unibolos.internal.encomenda.dto.EncomendaResumoResponse;
import uniesp.unibolos.internal.encomenda.entity.EncomendaEntity;
import uniesp.unibolos.internal.encomenda.repository.EncomendaRepository;
import uniesp.unibolos.internal.cliente.repository.ClienteRepository;
import uniesp.unibolos.internal.funcionario.repository.FuncionarioRepository;
import uniesp.unibolos.internal.cliente.entity.ClienteEntity;
import uniesp.unibolos.internal.funcionario.entity.FuncionarioEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EncomendaService {

    private final EncomendaRepository encomendaRepository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;

    public EncomendaResumoResponse criarEncomenda(CriarEncomendaRequest request) {

        ClienteEntity cliente = clienteRepository.findById(request.id_cliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        FuncionarioEntity funcionario = funcionarioRepository.findById(request.id_funcionario())
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));

        EncomendaEntity encomenda = new EncomendaEntity(
                request.descricao(),
                request.quantidade(),
                request.valorTotal(),
                request.dataEntrega(),
                request.status(),
                request.observacoes()
        );

        encomenda.associarCliente(cliente);
        encomenda.associarFuncionario(funcionario);

        encomendaRepository.save(encomenda);

        return converterParaResponse(encomenda);
    }

    public EncomendaResumoResponse buscarEncomendaPorId(Long id) {

        EncomendaEntity encomenda = encomendaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Encomenda não encontrada"));

        return converterParaResponse(encomenda);
    }

    public Page<EncomendaResumoResponse> listarTodos(Pageable pageable) {

        return encomendaRepository.findAll(pageable)
                .map(this::converterParaResponse);
    }

    private EncomendaResumoResponse converterParaResponse(EncomendaEntity encomenda) {

        return new EncomendaResumoResponse(
                encomenda.getId_encomenda(),
                encomenda.getCliente().getId_cliente(),
                encomenda.getFuncionario().getIdFuncionario(),
                encomenda.getDescricao(),
                encomenda.getQuantidade(),
                encomenda.getValorTotal(),
                encomenda.getDataPedido(),
                encomenda.getDataEntrega(),
                encomenda.getStatus(),
                encomenda.getObservacoes()
        );
    }

}
