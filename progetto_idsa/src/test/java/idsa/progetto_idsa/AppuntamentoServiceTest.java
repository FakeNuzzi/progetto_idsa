package idsa.progetto_idsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.repository.AppuntamentoRepository;
import idsa.progetto_idsa.service.AppuntamentoService;
import idsa.progetto_idsa.service.impl.AppuntamentoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AppuntamentoServiceTest {
    @Mock
    private AppuntamentoRepository appuntamentoRepository;
    private AutoCloseable autoCloseable;
    private AppuntamentoService appuntamentoService;

    @BeforeEach
    void setUp() throws Exception{
        autoCloseable = MockitoAnnotations.openMocks(this);
        appuntamentoService = new AppuntamentoServiceImpl(appuntamentoRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testGetAllAppuntamenti() {
        appuntamentoService.getAllAppuntamenti();
        verify(appuntamentoRepository).findAll();
    }

    @Test
    void testGetAllAppuntamentiMapping() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        List<Appuntamento> appuntamenti = Collections.singletonList(appuntamento);
        when(appuntamentoRepository.findAll()).thenReturn(appuntamenti);

        List<AppuntamentoDto> appuntamentiDto = appuntamentoService.getAllAppuntamenti();

        assertEquals(1, appuntamentiDto.size());
        assertEquals(appuntamento.getId_appuntamento(), appuntamentiDto.get(0).getId_appuntamento());
        assertEquals(appuntamento.getData(), appuntamentiDto.get(0).getData());
        assertEquals(appuntamento.getTipo_visita(), appuntamentiDto.get(0).getTipo_visita());
        assertEquals(appuntamento.getPaziente(), appuntamentiDto.get(0).getPaziente());

    }

    @Test
    void testCreateAppuntamento() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        when(appuntamentoRepository.save(any(Appuntamento.class))).thenReturn(appuntamento);

        AppuntamentoDto created = appuntamentoService.createAppuntamento(appuntamentoDto);

        assertEquals(appuntamento.getId_appuntamento(), created.getId_appuntamento());
        assertEquals(appuntamento.getData(), created.getData());
        assertEquals(appuntamento.getTipo_visita(), created.getTipo_visita());
        assertEquals(appuntamento.getPaziente(), created.getPaziente());
    }

    @Test
    void testGetAppuntamentoById() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        when(appuntamentoRepository.findById(1L)).thenReturn(java.util.Optional.of(appuntamento));

        AppuntamentoDto found = appuntamentoService.getAppuntamentoById(1L);

        assertEquals(appuntamento.getId_appuntamento(), found.getId_appuntamento());
        assertEquals(appuntamento.getData(), found.getData());
        assertEquals(appuntamento.getTipo_visita(), found.getTipo_visita());
        assertEquals(appuntamento.getPaziente(), found.getPaziente());
    }

    @Test
    void testGetAppuntamentoByIdNotFound() {
        when(appuntamentoRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            appuntamentoService.getAppuntamentoById(1L);
        });
    }

    @Test
    void testUpdateAppuntamento() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        when(appuntamentoRepository.findById(1L)).thenReturn(java.util.Optional.of(appuntamento));
        when(appuntamentoRepository.save(any(Appuntamento.class))).thenReturn(appuntamento);

        AppuntamentoDto updated = appuntamentoService.updateAppuntamento(1L, appuntamentoDto);

        assertEquals(appuntamento.getId_appuntamento(), updated.getId_appuntamento());
        assertEquals(appuntamento.getData(), updated.getData());
        assertEquals(appuntamento.getTipo_visita(), updated.getTipo_visita());
        assertEquals(appuntamento.getPaziente(), updated.getPaziente());
    }

    @Test
    void testUpdateAppuntamentoNotFound() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        when(appuntamentoRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            appuntamentoService.updateAppuntamento(1L, appuntamentoDto);
        });
    }

    @Test
    void testDeleteAppuntamento() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        when(appuntamentoRepository.findById(1L)).thenReturn(java.util.Optional.of(appuntamento));
        appuntamentoService.deleteAppuntamento(1L);
        verify(appuntamentoRepository).deleteById(1L);
    }

    @Test
    void testDeleteAppuntamentoNotFound() {
        when(appuntamentoRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            appuntamentoService.deleteAppuntamento(1L);
        });
    }
}

