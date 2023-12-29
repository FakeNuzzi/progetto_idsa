package idsa.progetto_idsa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.AppuntamentoMapper;
import idsa.progetto_idsa.repository.AppuntamentoRepository;
import idsa.progetto_idsa.repository.MedicoRepository;
import idsa.progetto_idsa.repository.PazienteRepository;
import idsa.progetto_idsa.repository.RisultatoRepository;
import idsa.progetto_idsa.repository.SlotRepository;
import idsa.progetto_idsa.repository.VisitaRepository;
import idsa.progetto_idsa.service.AppuntamentoService;

@Service
public class AppuntamentoServiceImpl implements AppuntamentoService {
    @Autowired
    private AppuntamentoRepository appuntamentoRepository;
    @Autowired
    private PazienteRepository pazienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private RisultatoRepository risultatoRepository;
    @Autowired
    private VisitaRepository visitaRepository;
    @Autowired
    private SlotRepository slotRepository;

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
        appuntamento.setPagato(updatedAppuntamento.getPagato());
        appuntamento.setPaziente(pazienteRepository.findById(updatedAppuntamento.getId_paziente())
            .orElseThrow(() -> new ResourceNotFoundException("Paziente non esiste per l'id dato : " + updatedAppuntamento.getId_paziente())));
        appuntamento.setMedico(medicoRepository.findById(updatedAppuntamento.getId_medico())
            .orElseThrow(() -> new ResourceNotFoundException("Medico non esiste per l'id dato : " + updatedAppuntamento.getId_medico())));
        appuntamento.setRisultato(risultatoRepository.findById(updatedAppuntamento.getId_risultato())
            .orElseThrow(() -> new ResourceNotFoundException("Risultato non esiste per l'id dato : " + updatedAppuntamento.getId_risultato())));
        appuntamento.setVisita(visitaRepository.findById(updatedAppuntamento.getTipo_visita())
            .orElseThrow(() -> new ResourceNotFoundException("Visita non esiste per l'id dato : " + updatedAppuntamento.getTipo_visita())));
        appuntamento.setSlot(slotRepository.findById(updatedAppuntamento.getDataOraSlot())
            .orElseThrow(() -> new ResourceNotFoundException("Slot non esiste per l'id dato : " + updatedAppuntamento.getDataOraSlot())));

        Appuntamento updatedAppuntamentoObj = appuntamentoRepository.save(appuntamento);

        return AppuntamentoMapper.mapToAppuntamentoDto(updatedAppuntamentoObj);
    }

    @Override
    public void deleteAppuntamento(Long id_appuntamento){
        appuntamentoRepository.findById(id_appuntamento)
            .orElseThrow(() -> new ResourceNotFoundException("Appuntamento non esiste per l'id dato : " + id_appuntamento));
        appuntamentoRepository.deleteById(id_appuntamento);
    }

    @Override
    public List<AppuntamentoDto> getAppuntamentiByMedico(Long id_medico){
        Medico medico = medicoRepository.findById(id_medico)
            .orElseThrow(() -> new ResourceNotFoundException("Medico non esiste per l'id dato : " + id_medico));
        List<Appuntamento> appuntamenti = appuntamentoRepository.findByMedico(medico);
        return appuntamenti.stream().map((appuntamento) -> AppuntamentoMapper.mapToAppuntamentoDto(appuntamento))
            .collect(Collectors.toList());
    }
}
