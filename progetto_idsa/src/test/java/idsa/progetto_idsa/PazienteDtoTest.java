package idsa.progetto_idsa;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;

import idsa.progetto_idsa.dto.MedicoDto;
import idsa.progetto_idsa.dto.PazienteDto;

public class PazienteDtoTest {
    @Test
    public void testGetId_paziente() {
        PazienteDto pazienteDto = new PazienteDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        assertTrue(pazienteDto.getId_paziente().equals(1L));
    }

    @Test
    public void testSetId_paziente() {
        PazienteDto pazienteDto = new PazienteDto();
        pazienteDto.setId_paziente(1L);
        assertTrue(pazienteDto.getId_paziente().equals(1L));
    }

    @Test
    public void testGetNome() {
        PazienteDto pazienteDto = new PazienteDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        assertTrue(pazienteDto.getNome().equals("Mario"));
    }

    @Test
    public void testSetNome() {
        PazienteDto pazienteDto = new PazienteDto();
        pazienteDto.setNome("Mario");
        assertTrue(pazienteDto.getNome().equals("Mario"));
    }

    @Test
    public void testGetCognome() {
        PazienteDto pazienteDto = new PazienteDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        assertTrue(pazienteDto.getCognome().equals("Rossi"));
    }

    @Test
    public void testSetCognome() {
        PazienteDto pazienteDto = new PazienteDto();
        pazienteDto.setCognome("Rossi");
        assertTrue(pazienteDto.getCognome().equals("Rossi"));
    }

    @Test
    public void testGetData_n() {
        PazienteDto pazienteDto = new PazienteDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        assertTrue(pazienteDto.getData_n().equals(Date.valueOf("1990-01-01")));
    }

    @Test
    public void testSetData_n() {
        PazienteDto pazienteDto = new PazienteDto();
        pazienteDto.setData_n(Date.valueOf("1990-01-01"));
        assertTrue(pazienteDto.getData_n().equals(Date.valueOf("1990-01-01")));
    }

    @Test
    public void testGetCf() {
        PazienteDto pazienteDto = new PazienteDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        assertTrue(pazienteDto.getCf().equals("RSSMRA90A01H501A"));
    }

    @Test
    public void testSetCf() {
        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setCf("RSSMRA90A01H501A");
        assertTrue(medicoDto.getCf().equals("RSSMRA90A01H501A"));
    }

}
