package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.PazienteDto;

public interface PazienteService {
    PazienteDto createPaziente(PazienteDto pazienteDto);
    PazienteDto getPazienteById(Long id_paziente);
    List<PazienteDto> getAllPazienti();
}
