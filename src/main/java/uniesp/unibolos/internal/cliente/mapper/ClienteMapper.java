package uniesp.unibolos.internal.cliente.mapper;

import uniesp.unibolos.internal.cliente.dto.ClienteResumoResponse;
import uniesp.unibolos.internal.cliente.entity.ClienteEntity;

public final class ClienteMapper {

    private ClienteMapper() {
    }

    public static ClienteResumoResponse paraResumoResposta(ClienteEntity cliente) {
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
