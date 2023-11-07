package idsa.progetto_idsa.service.impl;

import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.mapper.PazienteMapper;
import idsa.progetto_idsa.repository.PazienteRepository;
import idsa.progetto_idsa.service.PazienteService;
import lombok.AllArgsConstructor;
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
}
