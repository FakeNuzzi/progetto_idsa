package idsa.progetto_idsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import idsa.progetto_idsa.dto.TicketDto;
import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entity.Ticket;
import idsa.progetto_idsa.entityID.TicketID;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.repository.TicketRepository;
import idsa.progetto_idsa.service.TicketService;
import idsa.progetto_idsa.service.impl.TicketServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {
    @Mock
    private TicketRepository ticketRepository;
    private AutoCloseable autoCloseable;
    private TicketService ticketService;

    @BeforeEach
    void setUp() throws Exception{
        autoCloseable = MockitoAnnotations.openMocks(this);
        ticketService = new TicketServiceImpl(ticketRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testGetAllTickets() {
        ticketService.getAllTickets();
        verify(ticketRepository).findAll();
    }

    @Test
    void testGetAllTicketsMapping() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        Ticket ticket = new Ticket(1L, appuntamento, 100.0f, true, paziente);
        List<Ticket> tickets = Collections.singletonList(ticket);
        when(ticketRepository.findAll()).thenReturn(tickets);

        List<TicketDto> ticketsDto = ticketService.getAllTickets();

        assertEquals(1, ticketsDto.size());
        assertEquals(ticket.getId_ticket(), ticketsDto.get(0).getId_ticket());
        assertEquals(ticket.getAppuntamento(), ticketsDto.get(0).getAppuntamento());
        assertEquals(ticket.getPrezzo(), ticketsDto.get(0).getPrezzo());
        assertEquals(ticket.getStato(), ticketsDto.get(0).getStato());
        assertEquals(ticket.getPaziente(), ticketsDto.get(0).getPaziente());
    }

    @Test
    void testCreateTicket() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        Ticket ticket = new Ticket(1L, appuntamento, 100.0f, true, paziente);
        TicketDto ticketDto = new TicketDto(1L, appuntamento, 100.0f, true, paziente);
        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);

        TicketDto created = ticketService.createTicket(ticketDto);

        assertEquals(ticket.getId_ticket(), created.getId_ticket());
        assertEquals(ticket.getAppuntamento(), created.getAppuntamento());
        assertEquals(ticket.getPrezzo(), created.getPrezzo());
        assertEquals(ticket.getStato(), created.getStato());
        assertEquals(ticket.getPaziente(), created.getPaziente());
    }

    @Test
    void testGetTicketById() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        Ticket ticket = new Ticket(1L, appuntamento, 100.0f, true, paziente);
        TicketID id_ticket = new TicketID(1L, appuntamento);
        when(ticketRepository.findById(id_ticket)).thenReturn(java.util.Optional.of(ticket));

        TicketDto found = ticketService.getTicketById(id_ticket);

        assertEquals(ticket.getId_ticket(), found.getId_ticket());
        assertEquals(ticket.getAppuntamento(), found.getAppuntamento());
        assertEquals(ticket.getPrezzo(), found.getPrezzo());
        assertEquals(ticket.getStato(), found.getStato());
        assertEquals(ticket.getPaziente(), found.getPaziente());
    }

    @Test
    void testGetTicketByIdNotFound() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        TicketID id_ticket = new TicketID(1L, appuntamento);
        when(ticketRepository.findById(id_ticket)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            ticketService.getTicketById(id_ticket);
        });
    }

    @Test
    void testUpdateTicket() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        Ticket ticket = new Ticket(1L, appuntamento, 100.0f, true, paziente);
        TicketID id_ticket = new TicketID(1L, appuntamento);
        TicketDto ticketDto = new TicketDto(1L, appuntamento, 100.0f, true, paziente);
        when(ticketRepository.findById(id_ticket)).thenReturn(java.util.Optional.of(ticket));
        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);

        TicketDto updated = ticketService.updateTicket(id_ticket, ticketDto);

        assertEquals(ticket.getId_ticket(), updated.getId_ticket());
        assertEquals(ticket.getAppuntamento(), updated.getAppuntamento());
        assertEquals(ticket.getPrezzo(), updated.getPrezzo());
        assertEquals(ticket.getStato(), updated.getStato());
        assertEquals(ticket.getPaziente(), updated.getPaziente());
    }

    @Test
    void testUpdateTicketNotFound() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        TicketID id_ticket = new TicketID(1L, appuntamento);
        TicketDto ticketDto = new TicketDto(1L, appuntamento, 100.0f, true, new Paziente());
        when(ticketRepository.findById(id_ticket)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            ticketService.updateTicket(id_ticket, ticketDto);
        });
    }

    @Test
    void testDeleteTicket() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        Ticket ticket = new Ticket(1L, appuntamento, 100.0f, true, paziente);
        TicketID id_ticket = new TicketID(1L, appuntamento);
        when(ticketRepository.findById(id_ticket)).thenReturn(java.util.Optional.of(ticket));
        ticketService.deleteTicket(id_ticket);
        verify(ticketRepository).deleteById(id_ticket);
    }

    @Test
    void testDeleteTicketNotFound() {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Cardiologia", paziente, medico);
        TicketID id_ticket = new TicketID(1L, appuntamento);
        
        when(ticketRepository.findById(id_ticket)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            ticketService.deleteTicket(id_ticket);
        });
    }
}