package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entityID.MedicoID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository <Medico, MedicoID> {
}
