package idsa.progetto_idsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import idsa.progetto_idsa.dto.RefertoDto;
import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Cartella;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entity.Referto;
import idsa.progetto_idsa.entityID.RefertoID;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.repository.RefertoRepository;
import idsa.progetto_idsa.service.RefertoService;
import idsa.progetto_idsa.service.impl.RefertoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class RefertoServiceTest {
    @Mock
    private RefertoRepository refertoRepository;
    private AutoCloseable autoCloseable;
    private RefertoService refertoService;

    @BeforeEach
    void setUp() throws Exception{
        autoCloseable = MockitoAnnotations.openMocks(this);
        refertoService = new RefertoServiceImpl(refertoRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testGetAllReferti() {
        refertoService.getAllReferti();
        verify(refertoRepository).findAll();
    }

    @Test
    void testGetAllRefertiMapping() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        Cartella cartella = new Cartella(1L, paziente, new ArrayList<Referto>());
        Referto referto = new Referto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        List<Referto> referti = Collections.singletonList(referto);
        
        when(refertoRepository.findAll()).thenReturn(referti);

        List<RefertoDto> refertiDto = refertoService.getAllReferti();

        assertEquals(1, refertiDto.size());
        assertEquals(referto.getId_referto(), refertiDto.get(0).getId_referto());
        
    }

    @Test
    void testCreateReferto() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        List<Referto> referti = new ArrayList<Referto>();
        for (int i = 0; i < 5; i++){
            Referto referto1 = new Referto((long)i, appuntamento, "Visita", "Prescrizione", null);
            referti.add(referto1);
        }
        Cartella cartella = new Cartella(1L, paziente, referti);
        Referto referto = new Referto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        RefertoDto refertoDto = new RefertoDto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        when(refertoRepository.save(any(Referto.class))).thenReturn(referto);

        RefertoDto created = refertoService.createReferto(refertoDto);

        assertEquals(referto.getId_referto(), created.getId_referto());
        assertEquals(referto.getAppuntamento(), created.getAppuntamento());
        assertEquals(referto.getTipo_vis(), created.getTipo_vis());
        assertEquals(referto.getPrescr(), created.getPrescr());
        assertEquals(referto.getCartella(), created.getCartella());
    }

    @Test
    void testGetRefertoById() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        Cartella cartella = new Cartella(1L, paziente, new ArrayList<Referto>());
        Referto referto = new Referto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        RefertoID id_referto = new RefertoID(1L, appuntamento);
        when(refertoRepository.findById(id_referto)).thenReturn(java.util.Optional.of(referto));

        RefertoDto found = refertoService.getRefertoById(id_referto);

        assertEquals(referto.getId_referto(), found.getId_referto());
        assertEquals(referto.getAppuntamento(), found.getAppuntamento());
        assertEquals(referto.getTipo_vis(), found.getTipo_vis());
        assertEquals(referto.getPrescr(), found.getPrescr());
        assertEquals(referto.getCartella(), found.getCartella());
    }

    @Test
    void testGetRefertoByIdNotFound() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        RefertoID id_referto = new RefertoID(1L, appuntamento);
        when(refertoRepository.findById(id_referto)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            refertoService.getRefertoById(id_referto);
        });
    }

    @Test
    void testUpdateReferto() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        List<Referto> referti = new ArrayList<Referto>();
        for (int i = 0; i < 5; i++){
            Referto referto1 = new Referto((long)i, appuntamento, "Visita", "Prescrizione", null);
            referti.add(referto1);
        }
        Cartella cartella = new Cartella(1L, paziente, referti);
        Referto referto = new Referto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        RefertoID id_referto = new RefertoID(1L, appuntamento);
        RefertoDto refertoDto = new RefertoDto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        when(refertoRepository.findById(id_referto)).thenReturn(java.util.Optional.of(referto));
        when(refertoRepository.save(any(Referto.class))).thenReturn(referto);

        RefertoDto updated = refertoService.updateReferto(id_referto, refertoDto);

        assertEquals(referto.getId_referto(), updated.getId_referto());
        assertEquals(referto.getAppuntamento(), updated.getAppuntamento());
        assertEquals(referto.getTipo_vis(), updated.getTipo_vis());
        assertEquals(referto.getPrescr(), updated.getPrescr());
        assertEquals(referto.getCartella(), updated.getCartella());
    }

    @Test
    void testUpdateRefertoNotFound() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        List<Referto> referti = new ArrayList<Referto>();
        for (int i = 0; i < 5; i++){
            Referto referto1 = new Referto((long)i, appuntamento, "Visita", "Prescrizione", null);
            referti.add(referto1);
        }
        Cartella cartella = new Cartella(1L, paziente, referti);
        RefertoID id_referto = new RefertoID(1L, appuntamento);
        RefertoDto refertoDto = new RefertoDto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        
        when(refertoRepository.findById(id_referto)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            refertoService.updateReferto(id_referto, refertoDto);
        });
    }

    @Test
    void testDeleteReferto() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referti);
        Referto referto = new Referto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        RefertoID id_referto = new RefertoID(1L, appuntamento);

        when(refertoRepository.findById(id_referto)).thenReturn(java.util.Optional.of(referto));
        refertoService.deleteReferto(id_referto);
        verify(refertoRepository).deleteById(id_referto);
    }

    @Test
    void testDeleteRefertoNotFound() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        RefertoID id_referto = new RefertoID(1L, appuntamento);
        
        when(refertoRepository.findById(id_referto)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            refertoService.deleteReferto(id_referto);
        });
    }
}
