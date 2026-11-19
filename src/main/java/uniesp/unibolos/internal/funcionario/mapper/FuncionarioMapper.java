
package uniesp.unibolos.internal.funcionario.mapper;

import uniesp.unibolos.internal.funcionario.dto.CriarFuncionarioRequest;
import uniesp.unibolos.internal.funcionario.dto.CriarFuncionarioResponse;
import uniesp.unibolos.internal.funcionario.entity.FuncionarioEntity;

public final class FuncionarioMapper {

    private FuncionarioMapper() {
    }

    public static FuncionarioEntity converteParaEntidade(
            CriarFuncionarioRequest request) {
        return new FuncionarioEntity(
                request.nome(),
                request.cargo(),
                request.email(),
                request.telefone()
        );
    }

    public static CriarFuncionarioResponse converterParaResposta(
            FuncionarioEntity funcionario) {
        return new CriarFuncionarioResponse(
                funcionario.getNome(),
                funcionario.getCargo(),
                funcionario.isAtivo()
        );
    }
}
