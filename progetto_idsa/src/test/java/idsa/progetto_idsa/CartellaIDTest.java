package idsa.progetto_idsa;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entityID.CartellaID;

public class CartellaIDTest {
    @Test
    void testEquals_SameObject() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        CartellaID cartellaID = new CartellaID(1L, paziente);
        assertTrue(cartellaID.equals(cartellaID));
    }

    @Test
    void testEquals_DifferentId_Cartella() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        CartellaID cartellaID1 = new CartellaID(1L, paziente);
        CartellaID cartellaID2 = new CartellaID(2L, paziente);
        assertFalse(cartellaID1.equals(cartellaID2));
    }

    @Test
    void testEquals_DifferentPaziente() {
        Paziente paziente1 = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Paziente paziente2 = new Paziente(2L, "Luigi", "Verdi", Date.valueOf("1990-01-01"), "LGVVRD90A01H501A");
        CartellaID cartellaID1 = new CartellaID(1L, paziente1);
        CartellaID cartellaID2 = new CartellaID(1L, paziente2);
        assertFalse(cartellaID1.equals(cartellaID2));
    }

    @Test
    void testSetId_cartella(){
        CartellaID cartellaID = new CartellaID();
        cartellaID.setId_cartella(1L);
        assertTrue(cartellaID.getId_cartella().equals(1L));
    }

    @Test
    void testSetPaziente(){
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        CartellaID cartellaID = new CartellaID();
        cartellaID.setPaziente(paziente);
        assertTrue(cartellaID.getPaziente().equals(paziente));
    }
}
