package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entityID.PazienteID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PazienteRepository extends JpaRepository<Paziente, PazienteID> {
}
