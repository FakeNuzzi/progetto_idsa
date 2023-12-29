package idsa.progetto_idsa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idsa.progetto_idsa.dto.MedicoDto;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.MedicoMapper;
import idsa.progetto_idsa.repository.MedicoRepository;
import idsa.progetto_idsa.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
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
            .orElseThrow(() -> new ResourceNotFoundException("Medico non esiste per l'id dato : " + id_medico));
            return MedicoMapper.mapToMedicoDto(medico);
    }

    @Override
    public List<MedicoDto> getAllMedici(){
        List<Medico> medici = medicoRepository.findAll();
        return medici.stream().map((medico) -> MedicoMapper.mapToMedicoDto(medico))
            .collect(Collectors.toList());
    }

    @Override
    public MedicoDto updateMedico(Long id_medico, MedicoDto updatedMedico){
        Medico medico = medicoRepository.findById(id_medico)
            .orElseThrow(() -> new ResourceNotFoundException("Medico non esiste per l'id dato : " + id_medico));
        medico.setNome(updatedMedico.getNome());
        medico.setCognome(updatedMedico.getCognome());
        medico.setData_n(updatedMedico.getData_n());
        medico.setCf(updatedMedico.getCf());
        medico.setEmail(updatedMedico.getEmail());
        medico.setPassword(updatedMedico.getPassword());
        medico.setStipendio(updatedMedico.getStipendio());
        medico.setSpecializ(updatedMedico.getSpecializ());
        medico.setAppuntamenti(updatedMedico.getAppuntamenti());
        medico.setVisite(updatedMedico.getVisite());

        Medico updatedMedicoObj = medicoRepository.save(medico);

        return MedicoMapper.mapToMedicoDto(updatedMedicoObj);
    }

    @Override
    public void deleteMedico(Long id_medico){
        medicoRepository.findById(id_medico)
            .orElseThrow(() -> new ResourceNotFoundException("Medico non esiste per l'id dato : " + id_medico));
        medicoRepository.deleteById(id_medico);
    }
}
