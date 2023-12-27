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

import idsa.progetto_idsa.dto.CartellaDto;
import idsa.progetto_idsa.entity.Cartella;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entity.Referto;
import idsa.progetto_idsa.entityID.CartellaID;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.repository.CartellaRepository;
import idsa.progetto_idsa.service.CartellaService;
import idsa.progetto_idsa.service.impl.CartellaServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CartellaServiceTest {
    @Mock
    private CartellaRepository cartellaRepository;
    private AutoCloseable autoCloseable;
    private CartellaService cartellaService;

    @BeforeEach
    void setUp() throws Exception{
        autoCloseable = MockitoAnnotations.openMocks(this);
        cartellaService = new CartellaServiceImpl(cartellaRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testGetAllCartelle() {
        cartellaService.getAllCartelle();
        verify(cartellaRepository).findAll();
    }

    @Test
    void testGetAllCartelleMapping() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referti);
        List<Cartella> cartelle = Collections.singletonList(cartella);
        when(cartellaRepository.findAll()).thenReturn(cartelle);

        List<CartellaDto> cartelleDto = cartellaService.getAllCartelle();

        assertEquals(1, cartelleDto.size());
        assertEquals(cartella.getId_cartella(), cartelleDto.get(0).getId_cartella());
        assertEquals(cartella.getPaziente(), cartelleDto.get(0).getPaziente());
        assertEquals(cartella.getReferti(), cartelleDto.get(0).getReferti());
    }

    @Test
    void testCreateCartella() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referti);
        CartellaDto cartellaDto = new CartellaDto(1L, paziente, referti);
        when(cartellaRepository.save(any(Cartella.class))).thenReturn(cartella);

        CartellaDto created = cartellaService.createCartella(cartellaDto);

        assertEquals(cartella.getId_cartella(), created.getId_cartella());
        assertEquals(cartella.getPaziente(), created.getPaziente());
        assertEquals(cartella.getReferti(), created.getReferti());
    }

    @Test
    void testGetCartellaById() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referti);
        CartellaID id_cartella = new CartellaID(1L, paziente);

        when(cartellaRepository.findById(id_cartella)).thenReturn(java.util.Optional.of(cartella));

        CartellaDto found = cartellaService.getCartellaById(id_cartella);

        assertEquals(cartella.getId_cartella(), found.getId_cartella());
        assertEquals(cartella.getPaziente(), found.getPaziente());
        assertEquals(cartella.getReferti(), found.getReferti());
    }

    @Test
    void testGetCartellaByIdNotFound() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        CartellaID id_cartella = new CartellaID(1L, paziente);
        when(cartellaRepository.findById(id_cartella)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            cartellaService.getCartellaById(id_cartella);
        });
    }

    @Test
    void testUpdateCartella() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referti);
        CartellaID id_cartella = new CartellaID(1L, paziente);
        CartellaDto cartellaDto = new CartellaDto(1L, paziente, referti);
        when(cartellaRepository.findById(id_cartella)).thenReturn(java.util.Optional.of(cartella));
        when(cartellaRepository.save(any(Cartella.class))).thenReturn(cartella);

        CartellaDto updated = cartellaService.updateCartella(id_cartella, cartellaDto);

        assertEquals(cartella.getId_cartella(), updated.getId_cartella());
        assertEquals(cartella.getPaziente(), updated.getPaziente());
        assertEquals(cartella.getReferti(), updated.getReferti());
    }

    @Test
    void testUpdateCartellaNotFound() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        CartellaID id_cartella = new CartellaID(1L, paziente);
        CartellaDto cartellaDto = new CartellaDto(1L, paziente, referti);
        when(cartellaRepository.findById(id_cartella)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            cartellaService.updateCartella(id_cartella, cartellaDto);
        });
    }

    @Test
    void testDeleteCartella() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referti);
        CartellaID id_cartella = new CartellaID(1L, paziente);
        when(cartellaRepository.findById(id_cartella)).thenReturn(java.util.Optional.of(cartella));
        cartellaService.deleteCartella(id_cartella);
        verify(cartellaRepository).deleteById(id_cartella);
    }

    @Test
    void testDeleteCartellaNotFound() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        CartellaID id_cartella = new CartellaID(1L, paziente);
        
        when(cartellaRepository.findById(id_cartella)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            cartellaService.deleteCartella(id_cartella);
        });
    }
}