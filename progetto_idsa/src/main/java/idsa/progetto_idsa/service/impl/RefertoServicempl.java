package idsa.progetto_idsa.service.impl;

import idsa.progetto_idsa.dto.RefertoDto;
import idsa.progetto_idsa.entity.Referto;
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
}
