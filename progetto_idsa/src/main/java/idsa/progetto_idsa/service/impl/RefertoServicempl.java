package idsa.progetto_idsa.service.impl;

import idsa.progetto_idsa.dto.RefertoDto;
import idsa.progetto_idsa.entity.Referto;
import idsa.progetto_idsa.entityID.RefertoID;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.RefertoMapper;
import idsa.progetto_idsa.repository.RefertoRepository;
import idsa.progetto_idsa.service.RefertoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RefertoServicempl implements RefertoService {
    private RefertoRepository refertoRepository;
    
    @Override
    public RefertoDto createReferto(RefertoDto refertoDto) {
        Referto referto = RefertoMapper.mapToReferto(refertoDto);
        Referto savedReferto = refertoRepository.save(referto);
        return RefertoMapper.mapToRefertoDto(savedReferto);
    }

    @Override
    public RefertoDto getRefertoById(RefertoID id_referto){
        Referto referto = refertoRepository.findById(id_referto)
            .orElseThrow(() -> new ResourceNotFoundException("Referto non esiste per un dato id : " + id_referto));
            return RefertoMapper.mapToRefertoDto(referto);
    }
}
