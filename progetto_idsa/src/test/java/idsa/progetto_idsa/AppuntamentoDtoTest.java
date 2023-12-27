package idsa.progetto_idsa;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;

public class AppuntamentoDtoTest {
    @Test
    public void testGetId_appuntamento() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        assertTrue(appuntamentoDto.getId_appuntamento().equals(1L));
    }

    @Test
    public void testSetId_appuntamento() {
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto();
        appuntamentoDto.setId_appuntamento(1L);
        assertTrue(appuntamentoDto.getId_appuntamento().equals(1L));
    }

    @Test
    public void testGetData() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        assertTrue(appuntamentoDto.getData().equals(Date.valueOf("2021-01-01")));
    }

    @Test
    public void testSetData() {
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto();
        appuntamentoDto.setData(Date.valueOf("2021-01-01"));
        assertTrue(appuntamentoDto.getData().equals(Date.valueOf("2021-01-01")));
    }

    @Test
    public void testGetTipo_visita() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        assertTrue(appuntamentoDto.getTipo_visita().equals("Visita"));
    }

    @Test
    public void testSetTipo_visita() {
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto();
        appuntamentoDto.setTipo_visita("Visita");
        assertTrue(appuntamentoDto.getTipo_visita().equals("Visita"));
    }

    @Test
    public void testGetPaziente() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        assertTrue(appuntamentoDto.getPaziente().equals(paziente));
    }

    @Test
    public void testSetPaziente() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto();
        appuntamentoDto.setPaziente(paziente);
        assertTrue(appuntamentoDto.getPaziente().equals(paziente));
    }

    @Test
    public void testGetMedico() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        assertTrue(appuntamentoDto.getMedico().equals(medico));
    }

    @Test
    public void testSetMedico(){
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto();
        appuntamentoDto.setMedico(medico);
        assertTrue(appuntamentoDto.getMedico().equals(medico));
    }
}
