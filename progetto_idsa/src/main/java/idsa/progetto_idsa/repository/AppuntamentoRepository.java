package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.dto.MedicoDto;
import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.entity.Appuntamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppuntamentoRepository extends JpaRepository <Appuntamento,Long> {
    List<Appuntamento> findByPaziente(PazienteDto pazienteDto);
    List<Appuntamento> findByMedico(MedicoDto medicoDto);
}
