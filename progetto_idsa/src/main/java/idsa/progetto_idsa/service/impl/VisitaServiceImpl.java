package idsa.progetto_idsa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idsa.progetto_idsa.dto.VisitaDto;
import idsa.progetto_idsa.entity.Visita;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.VisitaMapper;
import idsa.progetto_idsa.repository.MedicoRepository;
import idsa.progetto_idsa.repository.VisitaRepository;
import idsa.progetto_idsa.service.VisitaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VisitaServiceImpl implements VisitaService {
    @Autowired
    private VisitaRepository visitaRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public VisitaDto createVisita(VisitaDto visitaDto) {
        Visita visita = VisitaMapper.mapToVisita(visitaDto, medicoRepository);
        visita.setMedico(medicoRepository.findById(visitaDto.getId_medico()).get());
        Visita savedVisita = visitaRepository.save(visita);
        return VisitaMapper.mapToVisitaDto(savedVisita);
    }
    
    @Override
    public VisitaDto getVisitaById(Long id_visita){
        Visita visita = visitaRepository.findById(id_visita)
            .orElseThrow(() -> new ResourceNotFoundException("Visita not found"));
        return VisitaMapper.mapToVisitaDto(visita);
    }

    @Override
    public List<VisitaDto> getAllVisite(){
        List<Visita> visite = visitaRepository.findAll();
        return visite.stream().map((visita) -> VisitaMapper.mapToVisitaDto(visita))
            .collect(Collectors.toList());
    }

    @Override
    public VisitaDto updateVisita(Long id_visita, VisitaDto updatedVisita){
        Visita visita = visitaRepository.findById(id_visita)
            .orElseThrow(() -> new ResourceNotFoundException("Visita not found"));
        visita.setTipoVis(updatedVisita.getTipoVis());
        visita.setDescr(updatedVisita.getDescr());
        visita.setPrezzo(updatedVisita.getPrezzo());
        visita.setMedico(medicoRepository.findById(updatedVisita.getId_medico()).get());
        Visita updatedVisitaObj = visitaRepository.save(visita);

        return VisitaMapper.mapToVisitaDto(updatedVisitaObj);
    }

    @Override
    public void deleteVisita(Long id_visita){
        visitaRepository.findById(id_visita);
        visitaRepository.deleteById(id_visita);
    }
}