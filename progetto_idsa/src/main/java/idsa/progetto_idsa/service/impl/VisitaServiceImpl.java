package idsa.progetto_idsa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idsa.progetto_idsa.dto.VisitaDto;
import idsa.progetto_idsa.entity.Visita;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.VisitaMapper;
import idsa.progetto_idsa.repository.VisitaRepository;
import idsa.progetto_idsa.service.VisitaService;

@Service
public class VisitaServiceImpl implements VisitaService {
    @Autowired
    private VisitaRepository visitaRepository;

    @Override
    public VisitaDto createVisita(VisitaDto visitaDto) {
        Visita visita = VisitaMapper.mapToVisita(visitaDto);
        Visita savedVisita = visitaRepository.save(visita);
        return VisitaMapper.mapToVisitaDto(savedVisita);
    }
    
    @Override
    public VisitaDto getVisitaById(String tipo_vis){
        Visita visita = visitaRepository.findById(tipo_vis)
            .orElseThrow(() -> new ResourceNotFoundException("Visita non esiste per l'id dato : " + tipo_vis));
            return VisitaMapper.mapToVisitaDto(visita);
    }

    @Override
    public List<VisitaDto> getAllVisite(){
        List<Visita> visite = visitaRepository.findAll();
        return visite.stream().map((visita) -> VisitaMapper.mapToVisitaDto(visita))
            .collect(Collectors.toList());
    }

    @Override
    public VisitaDto updateVisita(String tipo_vis, VisitaDto updatedVisita){
        Visita visita = visitaRepository.findById(tipo_vis)
            .orElseThrow(() -> new ResourceNotFoundException("Visita non esiste per l'id dato : " + tipo_vis));
        visita.setDescr(updatedVisita.getDescr());
        visita.setPrezzo(updatedVisita.getPrezzo());
        visita.setMedico(updatedVisita.getMedico());
        visita.setAppuntamento(updatedVisita.getAppuntamento());

        Visita updatedVisitaObj = visitaRepository.save(visita);

        return VisitaMapper.mapToVisitaDto(updatedVisitaObj);
    }

    @Override
    public void deleteVisita(String tipo_vis){
        visitaRepository.findById(tipo_vis)
            .orElseThrow(() -> new ResourceNotFoundException("Visita non esiste per l'id dato : " + tipo_vis));
        visitaRepository.deleteById(tipo_vis);
    }
}