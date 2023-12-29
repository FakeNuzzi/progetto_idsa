package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.PazienteDto;

public interface PazienteService {
    PazienteDto createPaziente(PazienteDto pazienteDto);
    PazienteDto getPazienteById(Long id_utente);
    List<PazienteDto> getAllPazienti();
    PazienteDto updatePaziente(Long id_utente, PazienteDto updatedPaziente);
    void deletePaziente(Long id_utente);
}
