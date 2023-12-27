package idsa.progetto_idsa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Cartella;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entity.Referto;

public class RefertoTest {
    @Test
    void testEquals_SameObject() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        List<Referto> referti = new ArrayList<Referto>();
        for (int i = 0; i < 5; i++){
            Referto referto1 = new Referto((long)i, appuntamento, "Visita", "Prescrizione", null);
            referti.add(referto1);
        }
        Cartella cartella = new Cartella(1L, paziente, referti);
        Referto referto = new Referto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        assertTrue(referto.equals(referto));
    }

    @Test
    void testEquals_DifferentId_Referto() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        List<Referto> referti = new ArrayList<Referto>();
        for (int i = 0; i < 5; i++){
            Referto referto1 = new Referto((long)i, appuntamento, "Visita", "Prescrizione", null);
            referti.add(referto1);
        }
        Cartella cartella = new Cartella(1L, paziente, referti);
        Referto referto1 = new Referto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        Referto referto2 = new Referto(2L, appuntamento, "Visita", "Prescrizione", cartella);
        assertFalse(referto1.equals(referto2));
    }

    @Test
    void testEquals_DifferentAppuntamento() {
        Paziente paziente1 = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Paziente paziente2 = new Paziente(2L, "Luigi", "Verdi", Date.valueOf("1990-01-01"), "LGVVRD90A01H501A");
        Medico medico1 = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Medico medico2 = new Medico(2L, "Luigi", "Verdi", Date.valueOf("1990-05-11"), "LGVVRD90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento1 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente1, medico1);
        Appuntamento appuntamento2 = new Appuntamento(2L, Date.valueOf("2022-12-01"), "Chirurgo", paziente2, medico2);
        List<Referto> referti = new ArrayList<Referto>();
        for (int i = 0; i < 5; i++){
            Referto referto1 = new Referto((long)i, appuntamento1, "Visita", "Prescrizione", null);
            referti.add(referto1);
        }
        Cartella cartella = new Cartella(1L, paziente1, referti);
        Referto referto1 = new Referto(1L, appuntamento1, "Visita", "Prescrizione", cartella);
        Referto referto2 = new Referto(1L, appuntamento2, "Visita", "Prescrizione", cartella);
        assertFalse(referto1.equals(referto2));
    }

    @Test
    void testEquals_DifferentTipo_Visita() {
        Paziente paziente1 = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Paziente paziente2 = new Paziente(2L, "Luigi", "Verdi", Date.valueOf("1990-01-01"), "LGVVRD90A01H501A");
        Medico medico1 = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Medico medico2 = new Medico(2L, "Luigi", "Verdi", Date.valueOf("1990-05-11"), "LGVVRD90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento1 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente1, medico1);
        Appuntamento appuntamento2 = new Appuntamento(2L, Date.valueOf("2022-12-01"), "Cardiologo", paziente2, medico2);
        List<Referto> referti = new ArrayList<Referto>();
        for (int i = 0; i < 5; i++){
            Referto referto1 = new Referto((long)i, appuntamento1, "Visita", "Prescrizione", null);
            referti.add(referto1);
        }
        Cartella cartella = new Cartella(1L, paziente1, referti);
        Referto referto1 = new Referto(1L, appuntamento1, "Visita", "Prescrizione", cartella);
        Referto referto2 = new Referto(1L, appuntamento2, "Visita", "Prescrizione", cartella);
        assertFalse(referto1.equals(referto2));
    }

    @Test
    void testEquals_DifferentPrescr() {
        Paziente paziente1 = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Paziente paziente2 = new Paziente(2L, "Luigi", "Verdi", Date.valueOf("1990-01-01"), "LGVVRD90A01H501A");
        Medico medico1 = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Medico medico2 = new Medico(2L, "Luigi", "Verdi", Date.valueOf("1990-05-11"), "LGVVRD90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento1 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente1, medico1);
        Appuntamento appuntamento2 = new Appuntamento(2L, Date.valueOf("2022-12-01"), "Chirurgo", paziente2, medico2);
        List<Referto> referti = new ArrayList<Referto>();
        for (int i = 0; i < 5; i++){
            Referto referto1 = new Referto((long)i, appuntamento1, "Visita", "Prescrizione", null);
            referti.add(referto1);
        }
        Cartella cartella = new Cartella(1L, paziente1, referti);
        Referto referto1 = new Referto(1L, appuntamento1, "Visita", "Prescrizione", cartella);
        Referto referto2 = new Referto(1L, appuntamento2, "Visita", "Prescrizione2", cartella);
        assertFalse(referto1.equals(referto2));
    }

    @Test
    void testEquals_DifferentCartella() {
        Paziente paziente1 = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Paziente paziente2 = new Paziente(2L, "Luigi", "Verdi", Date.valueOf("1990-01-01"), "LGVVRD90A01H501A");
        Medico medico1 = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Medico medico2 = new Medico(2L, "Luigi", "Verdi", Date.valueOf("1990-05-11"), "LGVVRD90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento1 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente1, medico1);
        Appuntamento appuntamento2 = new Appuntamento(2L, Date.valueOf("2022-12-01"), "Chirurgo", paziente2, medico2);
        List<Referto> referti1 = new ArrayList<Referto>();
        List<Referto> referti2 = new ArrayList<Referto>();
        for (int i = 0; i < 5; i++){
            Referto referto1 = new Referto((long)i, appuntamento1, "Visita", "Prescrizione", null);
            referti1.add(referto1);
        }
        for (int i = 0; i < 5; i++){
            Referto referto2 = new Referto((long)i, appuntamento2, "Visita", "Prescrizione", null);
            referti2.add(referto2);
        }
        Cartella cartella1 = new Cartella(1L, paziente1, referti1);
        Cartella cartella2 = new Cartella(2L, paziente2, referti2);
        Referto referto1 = new Referto(1L, appuntamento1, "Visita", "Prescrizione", cartella1);
        Referto referto2 = new Referto(1L, appuntamento2, "Visita", "Prescrizione", cartella2);
        assertFalse(referto1.equals(referto2));
    }

    @Test
    void testHashCode() {
        Paziente paziente1 = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico1 = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento1 = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente1, medico1);
        List<Referto> referti1 = new ArrayList<Referto>();
        for (int i = 0; i < 5; i++){
            Referto referto1 = new Referto((long)i, appuntamento1, "Visita", "Prescrizione", null);
            referti1.add(referto1);
        }
        Cartella cartella1 = new Cartella(1L, paziente1, referti1);
        Referto referto1 = new Referto(1L, appuntamento1, "Visita", "Prescrizione", cartella1);
        assertEquals(referto1.hashCode(), referto1.hashCode());
    }

    @Test
    void testSetId_Referto() {
        Referto referto = new Referto();
        referto.setId_referto(1L);
        assertEquals(1L, referto.getId_referto());
    }

    @Test
    void testSetId_Appuntamento(){
        Referto referto = new Referto();
        Appuntamento appuntamento = new Appuntamento();
        appuntamento.setId_appuntamento(1L);
        referto.setAppuntamento(appuntamento);
        assertEquals(1L, referto.getAppuntamento().getId_appuntamento());
    }

    @Test
    void testSetTipo_Visita(){
        Referto referto = new Referto();
        referto.setTipo_vis("Visita");
        assertEquals("Visita", referto.getTipo_vis());
    }

    @Test
    void setPrescr(){
        Referto referto = new Referto();
        referto.setPrescr("Prescrizione");
        assertEquals("Prescrizione", referto.getPrescr());
    }

    @Test
    void setCartella(){
        Referto referto = new Referto();
        Cartella cartella = new Cartella();
        cartella.setId_cartella(1L);
        referto.setCartella(cartella);
        assertEquals(1L, referto.getCartella().getId_cartella());
    }
    
}
