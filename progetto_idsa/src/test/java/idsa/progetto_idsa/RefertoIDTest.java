package idsa.progetto_idsa;

import org.junit.jupiter.api.Test;

import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entityID.RefertoID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

public class RefertoIDTest {
    @Test
    void testEquals_SameObject() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        RefertoID refertoID = new RefertoID(1L, appuntamento);
        assertTrue(refertoID.equals(refertoID));
    }
    @Test
    void testEquals_DifferentId_Referto() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        RefertoID refertoID1 = new RefertoID(1L, appuntamento);
        RefertoID refertoID2 = new RefertoID(2L, appuntamento);
        assertFalse(refertoID1.equals(refertoID2));
    }

    @Test
    void testEquals_DifferentAppuntamento(){
        Paziente paziente1 = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Paziente paziente2 = new Paziente(2L, "Luigi", "Verdi", Date.valueOf("1990-01-01"), "LGVVRD90A01H501A");
        Medico medico1 = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Medico medico2 = new Medico(2L, "Luigi", "Verdi", Date.valueOf("1990-05-11"), "LGVVRD90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento1 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente1, medico1);
        Appuntamento appuntamento2 = new Appuntamento(2L, Date.valueOf("2022-12-01"), "Chirurgo", paziente2, medico2);
        RefertoID refertoID1 = new RefertoID(1L, appuntamento1);
        RefertoID refertoID2 = new RefertoID(1L, appuntamento2);
        assertFalse(refertoID1.equals(refertoID2));
    }
    @Test
    void testSetId_Referto(){
        RefertoID refertoID = new RefertoID();
        refertoID.setId_referto(1L);
        assertEquals(1L, refertoID.getId_referto());
    }

    @Test
    void testSetAppuntamento(){
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        RefertoID refertoID = new RefertoID();
        refertoID.setAppuntamento(appuntamento);
        assertEquals(appuntamento, refertoID.getAppuntamento());
    }

}