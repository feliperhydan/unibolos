package uniesp.unibolos.internal.funcionario.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uniesp.unibolos.internal.funcionario.dto.CriarFuncionarioRequest;
import uniesp.unibolos.internal.funcionario.dto.CriarFuncionarioResponse;
import uniesp.unibolos.internal.funcionario.entity.FuncionarioEntity;
import uniesp.unibolos.internal.funcionario.mapper.FuncionarioMapper;
import uniesp.unibolos.internal.funcionario.repository.FuncionarioRepository;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Transactional
    public CriarFuncionarioResponse criarFuncionario(CriarFuncionarioRequest request) {
        FuncionarioEntity funcionario = FuncionarioMapper.converteParaEntidade(request);

        funcionarioRepository.save(funcionario);

        return FuncionarioMapper.converterParaResposta(funcionario);
    }
}
