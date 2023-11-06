package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.entity.Referto;
import idsa.progetto_idsa.entityID.RefertoID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RefertoRepository extends JpaRepository<Referto,RefertoID> {
}
