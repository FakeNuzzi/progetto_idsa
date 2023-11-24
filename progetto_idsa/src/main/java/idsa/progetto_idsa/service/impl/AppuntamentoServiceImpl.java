package idsa.progetto_idsa.service.impl;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.AppuntamentoMapper;
import idsa.progetto_idsa.repository.AppuntamentoRepository;
import idsa.progetto_idsa.service.AppuntamentoService;

@Service
@AllArgsConstructor
public class AppuntamentoServiceImpl implements AppuntamentoService{
    private AppuntamentoRepository appuntamentoRepository;
    @Override
    public AppuntamentoDto createAppuntamento(AppuntamentoDto appuntamentoDto) {
        Appuntamento appuntamento = AppuntamentoMapper.mapToAppuntamento(appuntamentoDto);
        Appuntamento savedAppuntamento = appuntamentoRepository.save(appuntamento);
        return AppuntamentoMapper.mapToAppuntamentoDto(savedAppuntamento);
    }
    
    @Override
    public AppuntamentoDto getAppuntamentoById(Long id_appuntamento){
        Appuntamento appuntamento = appuntamentoRepository.findById(id_appuntamento)
            .orElseThrow(() -> new ResourceNotFoundException("Appuntamento non esiste per l'id dato : " + id_appuntamento));
            return AppuntamentoMapper.mapToAppuntamentoDto(appuntamento);
    }

    @Override
    public List<AppuntamentoDto> getAllAppuntamenti(){
        List<Appuntamento> appuntamenti = appuntamentoRepository.findAll();
        return appuntamenti.stream().map((appuntamento) -> AppuntamentoMapper.mapToAppuntamentoDto(appuntamento))
            .collect(Collectors.toList());
    }

    @Override
    public AppuntamentoDto updateAppuntamento(Long id_appuntamento, AppuntamentoDto updatedAppuntamento){
        Appuntamento appuntamento = appuntamentoRepository.findById(id_appuntamento)
            .orElseThrow(() -> new ResourceNotFoundException("Appuntamento non esiste per l'id dato : " + id_appuntamento));
        appuntamento.setData(updatedAppuntamento.getData());
        appuntamento.setTipo_visita(updatedAppuntamento.getTipo_visita());
        appuntamento.setMedico(updatedAppuntamento.getMedico());
        appuntamento.setPaziente(updatedAppuntamento.getPaziente());

        Appuntamento updatedAppuntamentoObj = appuntamentoRepository.save(appuntamento);

        return AppuntamentoMapper.mapToAppuntamentoDto(updatedAppuntamentoObj);
    }

    @Override
    public void deleteAppuntamento(Long id_appuntamento){
        appuntamentoRepository.findById(id_appuntamento)
            .orElseThrow(() -> new ResourceNotFoundException("Appuntamento non esiste per l'id dato : " + id_appuntamento));
        appuntamentoRepository.deleteById(id_appuntamento);
    }
}