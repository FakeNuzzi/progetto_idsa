package idsa.progetto_idsa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entityID.TicketID;

public class TicketIDTest {
    @Test
    void testEquals_SameObject() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        TicketID ticket = new TicketID(1L, appuntamento);
        assertTrue(ticket.equals(ticket));
    }

    @Test
    void testEquals_DifferentId_ticket(){
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        TicketID ticket1 = new TicketID(1L, appuntamento);
        TicketID ticket2 = new TicketID(2L, appuntamento);
        assertFalse(ticket1.equals(ticket2));
    }

    @Test
    void testSetId_Ticket() {
        TicketID ticket = new TicketID();
        ticket.setId_ticket(1L);
        assertTrue(ticket.getId_ticket() == 1L);
    }

    @Test
    void testSetAppuntamento(){
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento1 = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        TicketID ticket = new TicketID();
        ticket.setAppuntamento(appuntamento1);
        assertTrue(ticket.getAppuntamento().equals(appuntamento1));
    }
}
