package uniesp.unibolos.internal.cliente.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniesp.unibolos.internal.cliente.dto.ClienteResumoResponse;
import uniesp.unibolos.internal.cliente.entity.ClienteEntity;
import uniesp.unibolos.internal.cliente.mapper.ClienteMapper;
import uniesp.unibolos.internal.cliente.repository.ClienteRepository;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public Page<ClienteResumoResponse> listarTodos(Pageable pageable) {
        return clienteRepository.findAll(pageable).map(ClienteMapper::paraResumoResposta);
    }

    @Transactional(readOnly = true)
    public ClienteResumoResponse buscarPorId(Long id) {
        ClienteEntity cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException(id));
        return ClienteMapper.paraResumoResposta(cliente);
    }
}
