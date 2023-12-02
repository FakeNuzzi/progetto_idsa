package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.entity.Cartella;
import idsa.progetto_idsa.entityID.CartellaID;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartellaRepository extends JpaRepository <Cartella, CartellaID> {
    List<Cartella> findByPaziente(PazienteDto pazienteDto);
}
