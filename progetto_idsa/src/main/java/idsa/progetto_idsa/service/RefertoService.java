package idsa.progetto_idsa.service;

import idsa.progetto_idsa.dto.RefertoDto;
import idsa.progetto_idsa.entityID.RefertoID;

public interface RefertoService {
    RefertoDto createReferto(RefertoDto refertoDto);
    RefertoDto getRefertoById(RefertoID id_referto);
}
