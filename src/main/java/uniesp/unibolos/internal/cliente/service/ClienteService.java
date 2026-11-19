package uniesp.unibolos.internal.cliente.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import uniesp.unibolos.internal.cliente.dto.ClienteResumoResponse;
import uniesp.unibolos.internal.cliente.dto.CriarClienteRequest;
import uniesp.unibolos.internal.cliente.dto.CriarClienteResponse;
import uniesp.unibolos.internal.cliente.entity.ClienteEntity;
import uniesp.unibolos.internal.cliente.mapper.ClienteMapper;
import uniesp.unibolos.internal.cliente.repository.ClienteRepository;
import uniesp.unibolos.shared.exception.RecursoNaoEncontradoException;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public CriarClienteResponse criarCliente(CriarClienteRequest request) {
        ClienteEntity cliente = ClienteMapper.converteParaEntidade(request);
        clienteRepository.save(cliente);
        return ClienteMapper.converterParaResposta(cliente);
    }

    @Transactional
    public void inativarCliente(Long id) {
        ClienteEntity cliente = clienteRepository.findById(id).orElseThrow(() ->
                new RecursoNaoEncontradoException("Cliente", id));
        cliente.desativar();
    }

    @Transactional
    public void ativarCliente(Long id) {
        ClienteEntity cliente = clienteRepository.findById(id).orElseThrow(() ->
                new RecursoNaoEncontradoException("Cliente", id));
        cliente.ativar();
    }

    public List<ClienteResumoResponse> listarClientes() {
        return clienteRepository.findAllByAtivoTrue()
                .stream()
                .map(ClienteMapper::paraResumoResposta)
                .toList();
    }
}
