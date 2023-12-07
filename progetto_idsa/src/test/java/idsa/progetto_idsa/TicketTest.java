package idsa.progetto_idsa;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entity.Ticket;

class TicketTest {

    @Test
    void testEquals_SameObject() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        Ticket ticket = new Ticket(1L, appuntamento, 100.0f, true, paziente);
        assertTrue(ticket.equals(ticket));
    }

    @Test
    void testEquals_DifferentId() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        Ticket ticket1 = new Ticket(1L, appuntamento, 100.0f, true, paziente);
        Ticket ticket2 = new Ticket(2L, appuntamento, 100.0f, true, paziente);
        assertFalse(ticket1.equals(ticket2));
    }

    @Test
    void testEquals_DifferentAppuntamento(){
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento1 = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        Appuntamento appuntamento2 = new Appuntamento(2L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        Ticket ticket1 = new Ticket(1L, appuntamento1, 100.0f, true, paziente);
        Ticket ticket2 = new Ticket(1L, appuntamento2, 100.0f, true, paziente);
        assertFalse(ticket1.equals(ticket2));
    }

    @Test
    void testEquals_DifferentPrezzo() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        Ticket ticket1 = new Ticket(1L, appuntamento, 100.0f, true, paziente);
        Ticket ticket2 = new Ticket(1L, appuntamento, 200.0f, true, paziente);
        assertFalse(ticket1.equals(ticket2));
    }

    @Test
    void testEquals_DifferentStato() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        Ticket ticket1 = new Ticket(1L, appuntamento, 100.0f, true, paziente);
        Ticket ticket2 = new Ticket(1L, appuntamento, 100.0f, false, paziente);
        assertFalse(ticket1.equals(ticket2));
    }

    @Test
    void testEquals_DifferentPaziente() {
        Paziente paziente1 = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Paziente paziente2 = new Paziente(2L, "Luigi", "Verdi", Date.valueOf("1992-02-02"), "VRDLGI92B02H501B");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente1, medico);
        Ticket ticket1 = new Ticket(1L, appuntamento, 100.0f, true, paziente1);
        Ticket ticket2 = new Ticket(1L, appuntamento, 100.0f, true, paziente2);
        assertFalse(ticket1.equals(ticket2));
    }

    @Test
    void testHashCode() {
        Ticket ticket1 = new Ticket(1L, new Appuntamento(), 100.0f, true, new Paziente());
        Ticket ticket2 = new Ticket(1L, new Appuntamento(), 100.0f, true, new Paziente());
        assertEquals(ticket1.hashCode(), ticket2.hashCode());
    }

    @Test
    void testSetId_Ticket() {
        Ticket ticket = new Ticket();
        ticket.setId_ticket(1L);
        assertEquals(1L, ticket.getId_ticket());
    }

    @Test
    void testSetAppuntamento() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        Ticket ticket = new Ticket(1L, appuntamento, 100.0f, true, paziente);
        ticket.setAppuntamento(appuntamento);
        assertEquals(appuntamento, ticket.getAppuntamento());
    }

    @Test
    void testSetPrezzo() {
        Ticket ticket = new Ticket();
        ticket.setPrezzo(100.0f);
        assertEquals(100.0f, ticket.getPrezzo());
    }

    @Test
    void testSetStato() {
        Ticket ticket = new Ticket();
        ticket.setStato(true);
        assertEquals(true, ticket.getStato());
    }

    @Test
    void testSetPaziente() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        Ticket ticket = new Ticket(1L, appuntamento, 100.0f, true, paziente);
        ticket.setPaziente(paziente);
        assertEquals(paziente, ticket.getPaziente());
    }
}