package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.dto.RisultatoDto;
import idsa.progetto_idsa.entity.Risultato;

public class RisultatoMapper {
    public static RisultatoDto mapToRisultatoDto(Risultato risultato) {
        return new RisultatoDto(
            risultato.getId_ris(),
            risultato.getReferto(),
            risultato.getPrescr(),
            risultato.getAppuntamento().getId_app()
        );
    }

    public static Risultato mapToRisultato(RisultatoDto risultatoDto) {
        return new Risultato(
            risultatoDto.getId_ris(),
            risultatoDto.getReferto(),
            risultatoDto.getPrescr(),
            risultatoDto.getAppuntamento()
        );
    }
}