package idsa.progetto_idsa.service.impl;

import lombok.AllArgsConstructor;
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
    private AppuntamentoRepository appunamentoRepository;
    @Override
    public AppuntamentoDto createAppuntamento(AppuntamentoDto appuntamentoDto) {
        Appuntamento appuntamento = AppuntamentoMapper.mapToAppuntamento(appuntamentoDto);
        Appuntamento savedAppuntamento = appunamentoRepository.save(appuntamento);
        return AppuntamentoMapper.mapToAppuntamentoDto(savedAppuntamento);
    }
    @Override
    
    public AppuntamentoDto getAppuntamentoById(Long id_appuntamento){
        Appuntamento appuntamento = appunamentoRepository.findById(id_appuntamento)
            .orElseThrow(() -> new ResourceNotFoundException("Appuntamento non esiste per un dato id : " + id_appuntamento));
            return AppuntamentoMapper.mapToAppuntamentoDto(appuntamento);
    }
}
