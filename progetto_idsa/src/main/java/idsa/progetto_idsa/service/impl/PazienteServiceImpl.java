package idsa.progetto_idsa.service.impl;

import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.PazienteMapper;
import idsa.progetto_idsa.repository.PazienteRepository;
import idsa.progetto_idsa.service.PazienteService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PazienteServiceImpl implements PazienteService {
    private PazienteRepository pazienteRepository;

    @Override
    public PazienteDto createPaziente(PazienteDto pazienteDto) {
        Paziente paziente = PazienteMapper.mapToPaziente(pazienteDto);
        Paziente savedPaziente = pazienteRepository.save(paziente);
        return PazienteMapper.mapToPazienteDto(savedPaziente);
    }

    @Override
    public PazienteDto getPazienteById(Long id_paziente){
        Paziente paziente = pazienteRepository.findById(id_paziente)
            .orElseThrow(() -> new ResourceNotFoundException("Paziente non esiste per un dato id : " + id_paziente));
            return PazienteMapper.mapToPazienteDto(paziente);
    }

    @Override
    public List<PazienteDto> getAllPazienti(){
        List<Paziente> pazienti = pazienteRepository.findAll();
        return pazienti.stream().map((paziente) -> PazienteMapper.mapToPazienteDto(paziente))
            .collect(Collectors.toList());
    }
}
