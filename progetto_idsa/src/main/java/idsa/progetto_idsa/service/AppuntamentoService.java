package idsa.progetto_idsa.service;

import java.util.List;
import java.util.Set;

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.dto.MedicoDto;
import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;

public interface AppuntamentoService {
    AppuntamentoDto createAppuntamento(AppuntamentoDto appuntamentoDto);
    AppuntamentoDto getAppuntamentoById(Long id_appuntamento);
    List<AppuntamentoDto> getAllAppuntamenti();
    AppuntamentoDto updateAppuntamento(Long id_appuntamento, AppuntamentoDto updatedAppuntamento);
    void deleteAppuntamento(Long id_appuntamento);

    List<AppuntamentoDto> findByPaziente(PazienteDto pazienteDto);

    List<AppuntamentoDto> findByMedico(MedicoDto medicoDto);
}
