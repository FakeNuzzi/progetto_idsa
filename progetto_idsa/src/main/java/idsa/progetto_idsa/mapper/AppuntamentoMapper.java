package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.entity.Appuntamento;

public class AppuntamentoMapper {
    public static AppuntamentoDto mapToAppuntamentoDto(Appuntamento appuntamento) {
        return new AppuntamentoDto(
            appuntamento.getId_app(),
            appuntamento.getPagato(),
            appuntamento.getPaziente().getId_utente(),
            appuntamento.getMedico().getId_utente(),
            appuntamento.getRisultato().getId_ris(),
            appuntamento.getVisita().getTipo_vis(),
            appuntamento.getSlot().getDataOraSlot()
        );
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
