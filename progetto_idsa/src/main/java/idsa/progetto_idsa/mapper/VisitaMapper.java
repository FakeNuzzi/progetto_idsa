package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.dto.VisitaDto;
import idsa.progetto_idsa.entity.Visita;
import idsa.progetto_idsa.repository.MedicoRepository;

public class VisitaMapper {
    public static VisitaDto mapToVisitaDto(Visita visita) {
        return new VisitaDto(
            visita.getId_vis(),
            visita.getTipoVis(),
            visita.getDescr(),
            visita.getPrezzo(),
            visita.getMedico().getId_utente()
        );
    }

    public static Visita mapToVisita(VisitaDto visitaDto, MedicoRepository medicoRepository) {
        return new Visita(
            visitaDto.getId_vis(),
            visitaDto.getTipoVis(),
            visitaDto.getDescr(),
            visitaDto.getPrezzo(),
            medicoRepository.findById(visitaDto.getId_medico())
                .orElseThrow(() -> new RuntimeException("Medico non trovato"))
        );
    }
}
