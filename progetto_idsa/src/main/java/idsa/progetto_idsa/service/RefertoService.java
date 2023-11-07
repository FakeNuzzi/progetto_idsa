package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.RefertoDto;
import idsa.progetto_idsa.entityID.RefertoID;

public interface RefertoService {
    RefertoDto createReferto(RefertoDto refertoDto);
    RefertoDto getRefertoById(RefertoID id_referto);
    List<RefertoDto> getAllReferti();
    RefertoDto updateReferto(RefertoID id_referto, RefertoDto updatedReferto);
}
