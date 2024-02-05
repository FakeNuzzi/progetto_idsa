package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.entity.Paziente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PazienteRepository extends JpaRepository<Paziente,Long> {
    Paziente findByEmail (String email);
}
