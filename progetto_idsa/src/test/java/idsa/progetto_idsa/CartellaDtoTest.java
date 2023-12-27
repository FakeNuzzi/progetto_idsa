package idsa.progetto_idsa;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import idsa.progetto_idsa.dto.CartellaDto;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entity.Referto;

public class CartellaDtoTest {
    @Test
    public void testGetId_cartella() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        CartellaDto cartellaDto = new CartellaDto(1L, paziente, referti);
        assertTrue(cartellaDto.getId_cartella().equals(1L));
    }

    @Test
    public void testSetId_cartella() {
        CartellaDto cartellaDto = new CartellaDto();
        cartellaDto.setId_cartella(1L);
        assertTrue(cartellaDto.getId_cartella().equals(1L));
    }

    @Test
    public void testGetPaziente() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        CartellaDto cartellaDto = new CartellaDto(1L, paziente, referti);
        assertTrue(cartellaDto.getPaziente().equals(paziente));
    }

    @Test
    public void testSetPaziente() {
        CartellaDto cartellaDto = new CartellaDto();
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        cartellaDto.setPaziente(paziente);
        assertTrue(cartellaDto.getPaziente().equals(paziente));
    }

    @Test
    public void testGetReferti() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        CartellaDto cartellaDto = new CartellaDto(1L, paziente, referti);
        assertTrue(cartellaDto.getReferti().equals(referti));
    }

    @Test
    public void testSetReferti() {
        CartellaDto cartellaDto = new CartellaDto();
        List<Referto> referti = new ArrayList<Referto>();
        cartellaDto.setReferti(referti);
        assertTrue(cartellaDto.getReferti().equals(referti));
    }
}
