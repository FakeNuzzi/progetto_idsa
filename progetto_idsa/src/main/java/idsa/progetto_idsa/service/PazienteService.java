package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.entityID.PazienteID;

public interface PazienteService {
    PazienteDto createPaziente(PazienteDto pazienteDto);
    PazienteDto getPazienteById(PazienteID id_paziente);
    List<PazienteDto> getAllPazienti();
    PazienteDto updatePaziente(PazienteID id_paziente, PazienteDto updatedPaziente);
    void deletePaziente(PazienteID id_paziente);
}
