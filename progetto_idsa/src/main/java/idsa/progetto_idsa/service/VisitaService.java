package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.VisitaDto;

public interface VisitaService {
    VisitaDto createVisita(VisitaDto pazienteDto);
    VisitaDto getVisitaById(String tipo_vis);
    List<VisitaDto> getAllVisite();
    VisitaDto updateVisita(String tipo_vis, VisitaDto updatedVisita);
    void deleteVisita(String tipo_vis);
}
