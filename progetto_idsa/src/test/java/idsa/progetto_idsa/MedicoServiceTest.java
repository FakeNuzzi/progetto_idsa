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

import idsa.progetto_idsa.dto.MedicoDto;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.repository.MedicoRepository;
import idsa.progetto_idsa.service.MedicoService;
import idsa.progetto_idsa.service.impl.MedicoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class MedicoServiceTest {
    @Mock
    private MedicoRepository medicoRepository;
    private AutoCloseable autoCloseable;
    private MedicoService medicoService;

    @BeforeEach
    void setUp() throws Exception{
        autoCloseable = MockitoAnnotations.openMocks(this);
        medicoService = new MedicoServiceImpl(medicoRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testGetAllMedici() {
        medicoService.getAllMedici();
        verify(medicoRepository).findAll();
    }

    @Test
    void testGetAllMediciMapping() {
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        List<Medico> medici = Collections.singletonList(medico);
        when(medicoRepository.findAll()).thenReturn(medici);

        List<MedicoDto> mediciDto = medicoService.getAllMedici();

        assertEquals(1, mediciDto.size());
        assertEquals(medico.getId_medico(), mediciDto.get(0).getId_medico());
        assertEquals(medico.getNome(), mediciDto.get(0).getNome());
        assertEquals(medico.getCognome(), mediciDto.get(0).getCognome());
        assertEquals(medico.getData_n(), mediciDto.get(0).getData_n());
        assertEquals(medico.getCf(), mediciDto.get(0).getCf());
    }

    @Test
    void testCreateMedico() {
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        MedicoDto medicoDto = new MedicoDto(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        when(medicoRepository.save(any(Medico.class))).thenReturn(medico);

        MedicoDto created = medicoService.createMedico(medicoDto);

        assertEquals(medico.getId_medico(), created.getId_medico());
        assertEquals(medico.getNome(), created.getNome());
        assertEquals(medico.getCognome(), created.getCognome());
        assertEquals(medico.getData_n(), created.getData_n());
        assertEquals(medico.getCf(), created.getCf());
    }

    @Test
    void testGetMedicoById() {
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        when(medicoRepository.findById(1L)).thenReturn(java.util.Optional.of(medico));

        MedicoDto found = medicoService.getMedicoById(1L);

        assertEquals(medico.getId_medico(), found.getId_medico());
        assertEquals(medico.getNome(), found.getNome());
        assertEquals(medico.getCognome(), found.getCognome());
        assertEquals(medico.getData_n(), found.getData_n());
        assertEquals(medico.getCf(), found.getCf());
    }

    @Test
    void testGetMedicoByIdNotFound() {
        when(medicoRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            medicoService.getMedicoById(1L);
        });
    }

    @Test
    void testUpdateMedico() {
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        MedicoDto medicoDto = new MedicoDto(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        when(medicoRepository.findById(1L)).thenReturn(java.util.Optional.of(medico));
        when(medicoRepository.save(any(Medico.class))).thenReturn(medico);

        MedicoDto updated = medicoService.updateMedico(1L, medicoDto);

        assertEquals(medico.getId_medico(), updated.getId_medico());
        assertEquals(medico.getNome(), updated.getNome());
        assertEquals(medico.getCognome(), updated.getCognome());
        assertEquals(medico.getData_n(), updated.getData_n());
        assertEquals(medico.getCf(), updated.getCf());
    }

    @Test
    void testUpdateMedicoNotFound() {
        MedicoDto medicoDto = new MedicoDto(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        when(medicoRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            medicoService.updateMedico(1L, medicoDto);
        });
    }

    @Test
    void testDeleteMedico() {
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        when(medicoRepository.findById(1L)).thenReturn(java.util.Optional.of(medico));
        medicoService.deleteMedico(1L);
        verify(medicoRepository).deleteById(1L);
    }

    @Test
    void testDeleteMedicoNotFound() {
        when(medicoRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            medicoService.deleteMedico(1L);
        });
    }
}

