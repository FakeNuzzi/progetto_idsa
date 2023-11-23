package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.entity.Referto;
import idsa.progetto_idsa.dto.RefertoDto;

public class RefertoMapper{
    public static RefertoDto mapToRefertoDto(Referto referto){
        return new RefertoDto(
            referto.getId_referto(),
            referto.getAppuntamento(),
            referto.getTipo_vis(),
            referto.getPrescr(),
            referto.getCartella()
        );
    }
    public static Referto mapToReferto(RefertoDto refertoDto){
        return new Referto(
            refertoDto.getId_referto(),
            refertoDto.getAppuntamento(),
            refertoDto.getTipo_vis(),
            refertoDto.getPrescr(),
            refertoDto.getCartella()
        );
    }    
}