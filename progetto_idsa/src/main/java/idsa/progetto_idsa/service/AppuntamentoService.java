package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.AppuntamentoDto;

public interface AppuntamentoService {
    AppuntamentoDto createAppuntamento(AppuntamentoDto appuntamentoDto);
    AppuntamentoDto getAppuntamentoById(Long id_app);
    List<AppuntamentoDto> getAllAppuntamenti();
    AppuntamentoDto updateAppuntamento(Long id_app, AppuntamentoDto updatedAppuntamento);
    void deleteAppuntamento(Long id_app);
}
