package idsa.progetto_idsa.service;

import idsa.progetto_idsa.dto.PazienteDto;

public interface PazienteService {
    PazienteDto createPaziente(PazienteDto pazienteDto);
    PazienteDto getPazienteById(Long id_paziente);
}
