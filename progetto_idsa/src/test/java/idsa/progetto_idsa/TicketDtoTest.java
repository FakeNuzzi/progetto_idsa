package idsa.progetto_idsa;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import idsa.progetto_idsa.dto.TicketDto;
import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;

public class TicketDtoTest {
    @Test
    public void testGetId_ticket() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        TicketDto ticketDto = new TicketDto(1L, appuntamento, 100.0f, true, paziente);
        assertTrue(ticketDto.getId_ticket().equals(1L));
    }

    @Test
    public void testSetId_ticket() {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId_ticket(1L);
        assertTrue(ticketDto.getId_ticket().equals(1L));
    }

    @Test
    public void testGetAppuntamento() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        TicketDto ticketDto = new TicketDto(1L, appuntamento, 100.0f, true, paziente);
        assertTrue(ticketDto.getAppuntamento().equals(appuntamento));
    }

    @Test
    public void testSetAppuntamento() {
        TicketDto ticketDto = new TicketDto();
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        ticketDto.setAppuntamento(appuntamento);
        assertTrue(ticketDto.getAppuntamento().equals(appuntamento));
    }

    @Test
    public void testGetPrezzo() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        TicketDto ticketDto = new TicketDto(1L, appuntamento, 100.0f, true, paziente);
        assertTrue(ticketDto.getPrezzo().equals(100.0f));
    }

    @Test
    public void testSetPrezzo() {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setPrezzo(100.0f);
        assertTrue(ticketDto.getPrezzo().equals(100.0f));
    }

    @Test
    public void testGetStato() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        TicketDto ticketDto = new TicketDto(1L, appuntamento, 100.0f, true, paziente);
        assertTrue(ticketDto.getStato().equals(true));
    }

    @Test
    public void testSetStato() {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setStato(true);
        assertTrue(ticketDto.getStato().equals(true));
    }

    @Test
    public void testGetPaziente() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Visita", paziente, medico);
        TicketDto ticketDto = new TicketDto(1L, appuntamento, 100.0f, true, paziente);
        assertTrue(ticketDto.getPaziente().equals(paziente));
    }

    @Test
    public void testSetPaziente() {
        TicketDto ticketDto = new TicketDto();
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        ticketDto.setPaziente(paziente);
        assertTrue(ticketDto.getPaziente().equals(paziente));
    }
}
