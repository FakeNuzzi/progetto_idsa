package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.VisitaDto;

public interface VisitaService {
    VisitaDto createVisita(VisitaDto pazienteDto);
    VisitaDto getVisitaById(Long id_visita);
    List<VisitaDto> getAllVisite();
    VisitaDto updateVisita(Long id_visita, VisitaDto updatedVisita);
    void deleteVisita(Long id_visita);
}
