package uniesp.unibolos.internal.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uniesp.unibolos.internal.cliente.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
