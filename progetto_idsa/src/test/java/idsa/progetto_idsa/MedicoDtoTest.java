package idsa.progetto_idsa;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;

import idsa.progetto_idsa.dto.MedicoDto;

public class MedicoDtoTest {
    @Test
    public void testGetId_medico() {
        MedicoDto medicoDto = new MedicoDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        assertTrue(medicoDto.getId_medico().equals(1L));
    }

    @Test
    public void testSetId_medico() {
        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setId_medico(1L);
        assertTrue(medicoDto.getId_medico().equals(1L));
    }

    @Test
    public void testGetNome() {
        MedicoDto medicoDto = new MedicoDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        assertTrue(medicoDto.getNome().equals("Mario"));
    }

    @Test
    public void testSetNome() {
        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setNome("Mario");
        assertTrue(medicoDto.getNome().equals("Mario"));
    }

    @Test
    public void testGetCognome() {
        MedicoDto medicoDto = new MedicoDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        assertTrue(medicoDto.getCognome().equals("Rossi"));
    }

    @Test
    public void testSetCognome() {
        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setCognome("Rossi");
        assertTrue(medicoDto.getCognome().equals("Rossi"));
    }

    @Test
    public void testGetData_n() {
        MedicoDto medicoDto = new MedicoDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        assertTrue(medicoDto.getData_n().equals(Date.valueOf("1990-01-01")));
    }

    @Test
    public void testSetData_n() {
        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setData_n(Date.valueOf("1990-01-01"));
        assertTrue(medicoDto.getData_n().equals(Date.valueOf("1990-01-01")));
    }

    @Test
    public void testGetCf() {
        MedicoDto medicoDto = new MedicoDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        assertTrue(medicoDto.getCf().equals("RSSMRA90A01H501A"));
    }

    @Test
    public void testSetCf() {
        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setCf("RSSMRA90A01H501A");
        assertTrue(medicoDto.getCf().equals("RSSMRA90A01H501A"));
    }

    @Test
    public void testGetStipendio() {
        MedicoDto medicoDto = new MedicoDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        assertTrue(medicoDto.getStipendio().equals(1000.0f));
    }

    @Test
    public void testSetStipendio() {
        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setStipendio(1000.0f);
        assertTrue(medicoDto.getStipendio().equals(1000.0f));
    }

    @Test
    public void testGetSpecializ() {
        MedicoDto medicoDto = new MedicoDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        assertTrue(medicoDto.getSpecializ().equals("Chirurgo"));
    }

    @Test
    public void testSetSpecializ() {
        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setSpecializ("Chirurgo");
        assertTrue(medicoDto.getSpecializ().equals("Chirurgo"));
    }
}
