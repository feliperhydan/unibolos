package uniesp.unibolos.internal.funcionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uniesp.unibolos.internal.funcionario.entity.FuncionarioEntity;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {
}
