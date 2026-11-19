package uniesp.unibolos.internal.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniesp.unibolos.internal.cliente.entity.ClienteEntity;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    List<ClienteEntity> findAllByAtivoTrue();
}
