package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.dto.AppuntamentoDto;

public class AppuntamentoMapper{
    public static AppuntamentoDto mapToAppuntamentoDto(Appuntamento appuntamento){
        return new AppuntamentoDto(
            appuntamento.getId_appuntamento(),
            appuntamento.getData(),
            appuntamento.getTipo_visita(),
            appuntamento.getPaziente(),
            appuntamento.getMedico()
        );
    } 

    public static Appuntamento mapToAppuntamento(AppuntamentoDto appuntamentoDto){
        return new Appuntamento(
            appuntamentoDto.getId_appuntamento(),
            appuntamentoDto.getData(),
            appuntamentoDto.getTipo_visita(),
            appuntamentoDto.getPaziente(),
            appuntamentoDto.getMedico()
        );
    }
}