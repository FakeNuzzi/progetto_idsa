package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.dto.VisitaDto;
import idsa.progetto_idsa.entity.Visita;

public class VisitaMapper {
    public static VisitaDto mapToVisitaDto(Visita visita) {
        return new VisitaDto(
            visita.getTipo_vis(),
            visita.getDescr(),
            visita.getPrezzo(),
            visita.getMedico().getId_utente(),
            visita.getAppuntamento().getId_app()
        );
    }

    public static Visita mapToVisita(VisitaDto visitaDto) {
        return new Visita(
            visitaDto.getTipo_vis(),
            visitaDto.getDescr(),
            visitaDto.getPrezzo(),
            visitaDto.getMedico(),
            visitaDto.getAppuntamento()
        );
    }
}
