package idsa.progetto_idsa;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Cartella;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entity.Referto;

public class CartellaTest {
    
    @Test
    void testEquals_SameObject() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referti);
        assertTrue(cartella.equals(cartella));
    }

    @Test
    void testEquals_DifferentId() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella1 = new Cartella(1L, paziente, referti);
        Cartella cartella2 = new Cartella(2L, paziente, referti);
        assertFalse(cartella1.equals(cartella2));
    }

    @Test
    void testEquals_DifferentPaziente() {
        Paziente paziente1 = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Paziente paziente2 = new Paziente(2L, "Luigi", "Verdi", Date.valueOf("1990-01-01"), "LGVVRD90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella1 = new Cartella(1L, paziente1, referti);
        Cartella cartella2 = new Cartella(1L, paziente2, referti);
        assertFalse(cartella1.equals(cartella2));
    }

    @Test
    void testEquals_DifferentReferti() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        List<Referto> referti1 = new ArrayList<Referto>();
        List<Referto> referti2 = new ArrayList<Referto>();

        for (int i = 0; i < 5; i++){
            Referto referto = new Referto((long)i, appuntamento, "Visita", "Prescrizione", null);
            referti1.add(referto);
        }
        for (int i = 5; i < 10; i++){
            Referto referto = new Referto((long)i, appuntamento, "Visita", "Prescrizione", null);
            referti2.add(referto);
        }
        
        Cartella cartella1 = new Cartella(1L, paziente, referti1);
        Cartella cartella2 = new Cartella(1L, paziente, referti2);
        assertFalse(cartella1.equals(cartella2));
    }

    @Test
    void testHashCode() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referti);
        assertEquals(cartella.hashCode(), cartella.hashCode());
    }

    @Test
    void testSetId_Cartella() {
        Cartella cartella = new Cartella();
        cartella.setId_cartella(1L);
        assertEquals(1L, cartella.getId_cartella());
    }

    @Test
    void testSetPaziente() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Cartella cartella = new Cartella();
        cartella.setPaziente(paziente);
        assertEquals(paziente, cartella.getPaziente());
    }

    @Test
    void testSetReferti() {
        List<Referto> referti = new ArrayList<Referto>();
        Cartella cartella = new Cartella();
        cartella.setReferti(referti);
        assertEquals(referti, cartella.getReferti());
    }
}
