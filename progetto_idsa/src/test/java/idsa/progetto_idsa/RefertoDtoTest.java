package idsa.progetto_idsa;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import idsa.progetto_idsa.dto.RefertoDto;
import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Cartella;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entity.Referto;

public class RefertoDtoTest {
    @Test
    public void testGetId_referto() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referti);
        RefertoDto refertoDto = new RefertoDto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        assertTrue(refertoDto.getId_referto().equals(1L));
    }

    @Test
    public void testSetId_referto() {
        RefertoDto refertoDto = new RefertoDto();
        refertoDto.setId_referto(1L);
        assertTrue(refertoDto.getId_referto().equals(1L));
    }

    @Test
    public void testGetAppuntamento() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referti);
        RefertoDto refertoDto = new RefertoDto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        assertTrue(refertoDto.getAppuntamento().equals(appuntamento));
    }

    @Test
    public void testSetAppuntamento() {
        RefertoDto refertoDto = new RefertoDto();
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        refertoDto.setAppuntamento(appuntamento);
        assertTrue(refertoDto.getAppuntamento().equals(appuntamento));
    }

    @Test
    public void testGetTipo_vis() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referti);
        RefertoDto refertoDto = new RefertoDto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        assertTrue(refertoDto.getTipo_vis().equals("Visita"));
    }

    @Test
    public void testSetTipo_vis() {
        RefertoDto refertoDto = new RefertoDto();
        refertoDto.setTipo_vis("Visita");
        assertTrue(refertoDto.getTipo_vis().equals("Visita"));
    }

    @Test
    public void testGetPrescr() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referti);
        RefertoDto refertoDto = new RefertoDto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        assertTrue(refertoDto.getPrescr().equals("Prescrizione"));
    }

    @Test
    public void testSetPrescr() {
        RefertoDto refertoDto = new RefertoDto();
        refertoDto.setPrescr("Prescrizione");
        assertTrue(refertoDto.getPrescr().equals("Prescrizione"));
    }

    @Test
    public void testGetCartella() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referti);
        RefertoDto refertoDto = new RefertoDto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        assertTrue(refertoDto.getCartella().equals(cartella));
    }

    @Test
    public void testSetCartella() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referti);
        RefertoDto refertoDto = new RefertoDto();
        refertoDto.setCartella(cartella);
        assertTrue(refertoDto.getCartella().equals(cartella));
    }
}
