package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppuntamentoRepository extends JpaRepository<Appuntamento,Long> {    
    List<Appuntamento> findByMedico(Medico medico);
    List<Appuntamento> findByPaziente(Paziente paziente);
}
