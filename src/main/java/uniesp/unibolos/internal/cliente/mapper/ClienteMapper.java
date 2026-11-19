package uniesp.unibolos.internal.cliente.mapper;

import uniesp.unibolos.internal.cliente.dto.ClienteResumoResponse;
import uniesp.unibolos.internal.cliente.dto.CriarClienteRequest;
import uniesp.unibolos.internal.cliente.dto.CriarClienteResponse;
import uniesp.unibolos.internal.cliente.entity.ClienteEntity;

public final class ClienteMapper {

    private ClienteMapper() {
    }

    public static ClienteEntity converteParaEntidade(CriarClienteRequest request) {
        return new ClienteEntity(
                request.nome(),
                request.cpf(),
                request.telefone(),
                request.email(),
                request.endereco()
        );
    }
    public static CriarClienteResponse converterParaResposta(ClienteEntity cliente) {
        return new CriarClienteResponse(
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getEndereco(),
                cliente.getCriadoEm()
        );
    }

    public static ClienteResumoResponse paraResumoResposta(
            ClienteEntity cliente) {
        return new ClienteResumoResponse(
                cliente.getId_cliente(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getEndereco(),
                cliente.getCriadoEm(),
                cliente.isAtivo()
        );
    }

}
