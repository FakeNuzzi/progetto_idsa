package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.dto.MedicoDto;
import idsa.progetto_idsa.dto.PazienteDto;

public interface AppuntamentoService {
    AppuntamentoDto createAppuntamento(AppuntamentoDto appuntamentoDto);
    AppuntamentoDto getAppuntamentoById(Long id_appuntamento);
    List<AppuntamentoDto> getAllAppuntamenti();
    AppuntamentoDto updateAppuntamento(Long id_appuntamento, AppuntamentoDto updatedAppuntamento);
    void deleteAppuntamento(Long id_appuntamento);

    List<AppuntamentoDto> findByPaziente(PazienteDto pazienteDto);

    List<AppuntamentoDto> findByMedico(MedicoDto medicoDto);
}
