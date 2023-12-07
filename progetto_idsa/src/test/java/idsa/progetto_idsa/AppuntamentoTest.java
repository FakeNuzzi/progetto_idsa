package idsa.progetto_idsa;

import org.junit.jupiter.api.Test;

import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

class AppuntamentoTest {

    @Test
    void testEquals_SameObject() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento1 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        assertTrue(appuntamento1.equals(appuntamento1));
    }

    @Test
    void testEquals_DifferentId() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento1 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        Appuntamento appuntamento2 = new Appuntamento(2L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        assertFalse(appuntamento1.equals(appuntamento2));
    }

    @Test
    void testEquals_DifferentDate() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento1 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        Appuntamento appuntamento2 = new Appuntamento(1L, Date.valueOf("2022-12-02"), "Chirurgo", paziente, medico);
        assertFalse(appuntamento1.equals(appuntamento2));
    }

    @Test
    void testEquals_DifferentTipo_Visita(){
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento1 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        Appuntamento appuntamento2 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Cardiologo", paziente, medico);
        assertFalse(appuntamento1.equals(appuntamento2));
    }

    @Test
    void testEquals_DifferentPaziente() {
        Paziente paziente1 = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Paziente paziente2 = new Paziente(2L, "Luigi", "Verdi", Date.valueOf("1992-02-02"), "VRDLGI92B02H501B");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento1 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente1, medico);
        Appuntamento appuntamento2 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente2, medico);
        assertFalse(appuntamento1.equals(appuntamento2));
    }

    @Test
    void testEquals_DifferentMedico() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico1 = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Medico medico2 = new Medico(2L, "Luigi", "Verdi", Date.valueOf("1992-02-02"), "VRDLGI92B02H501B", 2000.0f, "Cardiologo");
        Appuntamento appuntamento1 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico1);
        Appuntamento appuntamento2 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico2);
        assertFalse(appuntamento1.equals(appuntamento2));
    }

    @Test
    void testHashCode() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento1 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        Appuntamento appuntamento2 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        assertEquals(appuntamento1.hashCode(), appuntamento2.hashCode());
    }

    @Test
    void testSetId_Appuntamento() {
        Appuntamento appuntamento = new Appuntamento();
        appuntamento.setId_appuntamento(1L);
        assertEquals(1L, appuntamento.getId_appuntamento());
    }

    @Test
    void testSetData() {
        Appuntamento appuntamento = new Appuntamento();
        Date date = Date.valueOf("2022-12-01");
        appuntamento.setData(date);
        assertEquals(date, appuntamento.getData());
    }

    @Test
    void testSetTipo_Visita() {
        Appuntamento appuntamento = new Appuntamento();
        appuntamento.setTipo_visita("Chirurgo");
        assertEquals("Chirurgo", appuntamento.getTipo_visita());
    }

    @Test
    void testSetPaziente() {
        Appuntamento appuntamento = new Appuntamento();
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        appuntamento.setPaziente(paziente);
        assertEquals(paziente, appuntamento.getPaziente());
    }

    @Test
    void testSetMedico() {
        Appuntamento appuntamento = new Appuntamento();
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        appuntamento.setMedico(medico);
        assertEquals(medico, appuntamento.getMedico());
    }
}