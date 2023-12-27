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

import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.repository.PazienteRepository;
import idsa.progetto_idsa.service.PazienteService;
import idsa.progetto_idsa.service.impl.PazienteServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PazienteServiceTest {
    @Mock
    private PazienteRepository pazienteRepository;
    private AutoCloseable autoCloseable;
    private PazienteService pazienteService;

    @BeforeEach
    void setUp() throws Exception{
        autoCloseable = MockitoAnnotations.openMocks(this);
        pazienteService = new PazienteServiceImpl(pazienteRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testGetAllPazienti() {
        pazienteService.getAllPazienti();
        verify(pazienteRepository).findAll();
    }

    @Test
    void testGetAllPazientiMapping() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A");
        List<Paziente> pazienti = Collections.singletonList(paziente);
        when(pazienteRepository.findAll()).thenReturn(pazienti);

        List<PazienteDto> pazientiDto = pazienteService.getAllPazienti();

        assertEquals(1, pazientiDto.size());
        assertEquals(paziente.getId_paziente(), pazientiDto.get(0).getId_paziente());
        assertEquals(paziente.getNome(), pazientiDto.get(0).getNome());
        assertEquals(paziente.getCognome(), pazientiDto.get(0).getCognome());
        assertEquals(paziente.getData_n(), pazientiDto.get(0).getData_n());
        assertEquals(paziente.getCf(), pazientiDto.get(0).getCf());
    }

    @Test
    void testCreatePaziente() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A");
        PazienteDto pazienteDto = new PazienteDto(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A");
        when(pazienteRepository.save(any(Paziente.class))).thenReturn(paziente);

        PazienteDto created = pazienteService.createPaziente(pazienteDto);

        assertEquals(paziente.getId_paziente(), created.getId_paziente());
        assertEquals(paziente.getNome(), created.getNome());
        assertEquals(paziente.getCognome(), created.getCognome());
        assertEquals(paziente.getData_n(), created.getData_n());
        assertEquals(paziente.getCf(), created.getCf());
    }

    @Test
    void testGetPazienteById() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A");
        when(pazienteRepository.findById(1L)).thenReturn(java.util.Optional.of(paziente));

        PazienteDto found = pazienteService.getPazienteById(1L);

        assertEquals(paziente.getId_paziente(), found.getId_paziente());
        assertEquals(paziente.getNome(), found.getNome());
        assertEquals(paziente.getCognome(), found.getCognome());
        assertEquals(paziente.getData_n(), found.getData_n());
        assertEquals(paziente.getCf(), found.getCf());
    }

    @Test
    void testGetPazienteByIdNotFound() {
        when(pazienteRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            pazienteService.getPazienteById(1L);
        });
    }

    @Test
    void testUpdatePaziente() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A");
        PazienteDto pazienteDto = new PazienteDto(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A");
        when(pazienteRepository.findById(1L)).thenReturn(java.util.Optional.of(paziente));
        when(pazienteRepository.save(any(Paziente.class))).thenReturn(paziente);

        PazienteDto updated = pazienteService.updatePaziente(1L, pazienteDto);

        assertEquals(paziente.getId_paziente(), updated.getId_paziente());
        assertEquals(paziente.getNome(), updated.getNome());
        assertEquals(paziente.getCognome(), updated.getCognome());
        assertEquals(paziente.getData_n(), updated.getData_n());
        assertEquals(paziente.getCf(), updated.getCf());
    }

    @Test
    void testUpdatePazienteNotFound() {
        PazienteDto pazienteDto = new PazienteDto(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A");
        when(pazienteRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            pazienteService.updatePaziente(1L, pazienteDto);
        });
    }

    @Test
    void testDeletePaziente() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A");
        when(pazienteRepository.findById(1L)).thenReturn(java.util.Optional.of(paziente));
        pazienteService.deletePaziente(1L);
        verify(pazienteRepository).deleteById(1L);
    }

    @Test
    void testDeletePazienteNotFound() {
        when(pazienteRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            pazienteService.deletePaziente(1L);
        });
    }
}
