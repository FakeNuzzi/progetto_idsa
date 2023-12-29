package idsa.progetto_idsa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idsa.progetto_idsa.dto.RisultatoDto;
import idsa.progetto_idsa.entity.Risultato;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.RisultatoMapper;
import idsa.progetto_idsa.repository.RisultatoRepository;
import idsa.progetto_idsa.service.RisultatoService;

@Service
public class RisultatoServiceImpl implements RisultatoService {
    @Autowired
    private RisultatoRepository risultatoRepository;

    @Override
    public RisultatoDto createRisultato(RisultatoDto risultatoDto) {
        Risultato risultato = RisultatoMapper.mapToRisultato(risultatoDto);
        Risultato savedRisultato = risultatoRepository.save(risultato);
        return RisultatoMapper.mapToRisultatoDto(savedRisultato);
    }
    
    @Override
    public RisultatoDto getRisultatoById(Long id_risultato){
        Risultato risultato = risultatoRepository.findById(id_risultato)
            .orElseThrow(() -> new ResourceNotFoundException("Risultato non esiste per l'id dato : " + id_risultato));
            return RisultatoMapper.mapToRisultatoDto(risultato);
    }

    @Override
    public List<RisultatoDto> getAllRisultati(){
        List<Risultato> risultati = risultatoRepository.findAll();
        return risultati.stream().map((risultato) -> RisultatoMapper.mapToRisultatoDto(risultato))
            .collect(Collectors.toList());
    }

    @Override
    public RisultatoDto updateRisultato(Long id_risultato, RisultatoDto updatedRisultato){
        Risultato risultato = risultatoRepository.findById(id_risultato)
            .orElseThrow(() -> new ResourceNotFoundException("Risultato non esiste per l'id dato : " + id_risultato));
        risultato.setReferto(updatedRisultato.getReferto());
        risultato.setPrescr(updatedRisultato.getPrescr());
        risultato.setAppuntamento(updatedRisultato.getAppuntamento());

        Risultato updatedRisultatoObj = risultatoRepository.save(risultato);

        return RisultatoMapper.mapToRisultatoDto(updatedRisultatoObj);
    }

    @Override
    public void deleteRisultato(Long id_risultato){
        risultatoRepository.findById(id_risultato)
            .orElseThrow(() -> new ResourceNotFoundException("Risultato non esiste per l'id dato : " + id_risultato));
        risultatoRepository.deleteById(id_risultato);
    }
}
