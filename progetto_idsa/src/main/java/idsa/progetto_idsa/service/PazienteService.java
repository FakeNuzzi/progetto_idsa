package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.entity.Paziente;

public interface PazienteService {
    PazienteDto createPaziente(PazienteDto pazienteDto);
    PazienteDto getPazienteById(Long id_paziente);
    List<PazienteDto> getAllPazienti();
    PazienteDto updatePaziente(Long id_paziente, PazienteDto updatedPaziente);
    void deletePaziente(Long id_paziente);
}
