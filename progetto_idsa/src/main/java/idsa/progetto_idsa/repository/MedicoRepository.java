package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico,Long> {    
}