package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.entity.Appuntamento;

public class AppuntamentoMapper {
    public static AppuntamentoDto mapToAppuntamentoDto(Appuntamento appuntamento) {
        return new AppuntamentoDto(
            appuntamento.getId_app(),
            appuntamento.getPagato(),
            appuntamento.getId_paziente(),
            appuntamento.getId_medico(),
            appuntamento.getId_risultato(),
            appuntamento.getTipo_visita(),
            appuntamento.getDataOraSlot());
    }

    public static Appuntamento mapToAppuntamento(AppuntamentoDto appuntamentoDto) {
        return new Appuntamento(
            appuntamentoDto.getId_app(),
            appuntamentoDto.getPagato(),
            appuntamentoDto.getPaziente(),
            appuntamentoDto.getMedico(),
            appuntamentoDto.getRisultato(),
            appuntamentoDto.getVisita(),
            appuntamentoDto.getSlot());
    }
}
