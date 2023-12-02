package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.dto.MedicoDto;
import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import jakarta.persistence.SecondaryTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface AppuntamentoRepository extends JpaRepository <Appuntamento,Long> {
    List<Appuntamento> findByPaziente(PazienteDto pazienteDto);
    List<Appuntamento> findByMedico(MedicoDto medicoDto);
}
