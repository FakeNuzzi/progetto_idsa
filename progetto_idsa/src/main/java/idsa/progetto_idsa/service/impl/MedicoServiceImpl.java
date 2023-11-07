package idsa.progetto_idsa.service.impl;

import idsa.progetto_idsa.dto.MedicoDto;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.MedicoMapper;
import idsa.progetto_idsa.repository.MedicoRepository;
import idsa.progetto_idsa.service.MedicoService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicoServiceImpl implements MedicoService {
    private MedicoRepository medicoRepository;
    
    @Override
    public MedicoDto createMedico(MedicoDto medicoDto) {
        Medico medico = MedicoMapper.mapToMedico(medicoDto);
        Medico savedMedico = medicoRepository.save(medico);
        return MedicoMapper.mapToMedicoDto(savedMedico);
    }

    @Override
    public MedicoDto getMedicoById(Long id_medico){
        Medico medico = medicoRepository.findById(id_medico)
            .orElseThrow(() -> new ResourceNotFoundException("Medico non esiste per un dato id : " + id_medico));
            return MedicoMapper.mapToMedicoDto(medico);
    }

    @Override
    public List<MedicoDto> getAllMedici(){
        List<Medico> medici = medicoRepository.findAll();
        return medici.stream().map((medico) -> MedicoMapper.mapToMedicoDto(medico))
            .collect(Collectors.toList());
    }
}
