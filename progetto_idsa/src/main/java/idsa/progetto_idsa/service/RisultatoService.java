package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.RisultatoDto;

public interface RisultatoService {
    RisultatoDto createRisultato(RisultatoDto risultatoDto);
    RisultatoDto getRisultatoById(Long id_ris);
    List<RisultatoDto> getAllRisultati();
    RisultatoDto updateRisultato(Long id_ris, RisultatoDto updatedRisultato);
    void deleteRisultato(Long id_ris);
    List<RisultatoDto> getRisultatiByPaziente(Long id_utente);
}