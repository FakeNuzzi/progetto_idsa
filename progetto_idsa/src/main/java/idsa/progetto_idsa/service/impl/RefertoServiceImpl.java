package idsa.progetto_idsa.service.impl;

import idsa.progetto_idsa.dto.RefertoDto;
import idsa.progetto_idsa.entity.Referto;
import idsa.progetto_idsa.entityID.RefertoID;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.RefertoMapper;
import idsa.progetto_idsa.repository.RefertoRepository;
import idsa.progetto_idsa.service.RefertoService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RefertoServiceImpl implements RefertoService {
    @Autowired
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

    @Override
    public List<RefertoDto> getAllReferti(){
        List<Referto> referti = refertoRepository.findAll();
        return referti.stream().map((referto) -> RefertoMapper.mapToRefertoDto(referto))
            .collect(Collectors.toList());
    }

    @Override
    public RefertoDto updateReferto(RefertoID id_referto, RefertoDto updatedReferto){
        Referto referto = refertoRepository.findById(id_referto)
            .orElseThrow(() -> new ResourceNotFoundException("Referto non esiste per l'id dato : " + id_referto));
        referto.setAppuntamento(updatedReferto.getAppuntamento());
        referto.setTipo_vis(updatedReferto.getTipo_vis());
        referto.setPrescr(updatedReferto.getPrescr());
        referto.setCartella(updatedReferto.getCartella());

        Referto updatedRefertoObj = refertoRepository.save(referto);

        return RefertoMapper.mapToRefertoDto(updatedRefertoObj);
    }

    @Override
    public void deleteReferto(RefertoID id_referto){
        refertoRepository.findById(id_referto)
            .orElseThrow(() -> new ResourceNotFoundException("Referto non esiste per l'id dato : " + id_referto));
        refertoRepository.deleteById(id_referto);
    }

    /*
    @Override
    public List<RefertoDto> findByAppuntamento(AppuntamentoDto appuntamentoDto) {
        List<Referto> referti = refertoRepository.findByAppuntamento(appuntamentoDto);
        return referti.stream().map((referto) -> RefertoMapper.mapToRefertoDto(referto))
                .collect(Collectors.toList());
    }

    @Override
    public List<RefertoDto> findByCartella(CartellaDto cartellaDto) {
        List<Referto> referti = refertoRepository.findByCartella(cartellaDto);
        return referti.stream().map((referto) -> RefertoMapper.mapToRefertoDto(referto))
                .collect(Collectors.toList());
    }
    */

}
