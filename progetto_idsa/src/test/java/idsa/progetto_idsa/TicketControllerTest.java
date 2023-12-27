package idsa.progetto_idsa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import idsa.progetto_idsa.dto.TicketDto;
import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entityID.TicketID;
import idsa.progetto_idsa.service.TicketService;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureMockMvc
class TicketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketService ticketService;

    @Test
    public void testGetAllAppuntamenti() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Chirurgo", paziente, medico);
        TicketDto ticket = new TicketDto(1L, appuntamento, 1000.0f, true, paziente);
        List<TicketDto> tickets = Collections.singletonList(ticket);
        when(ticketService.getAllTickets()).thenReturn(tickets);

        mockMvc.perform(get("/api/tickets")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id_ticket", is(ticket.getId_ticket().intValue())))
                .andExpect(jsonPath("$[0].appuntamento.id_appuntamento", is(ticket.getAppuntamento().getId_appuntamento().intValue())))
                .andExpect(jsonPath("$[0].stato", is(ticket.getStato())))
                .andExpect(jsonPath("$[0].paziente.id_paziente", is(ticket.getPaziente().getId_paziente().intValue())));
    }

    @Test
    public void testGetTicketById() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Chirurgo", paziente, medico);
        TicketDto ticket = new TicketDto(1L, appuntamento, 1000.0f, true, paziente);
        TicketID ticketID = new TicketID(1L, appuntamento);
        when(ticketService.getTicketById(any(TicketID.class))).thenReturn(ticket);

        mockMvc.perform(get("/api/tickets/{id_ticket}/{id_appuntamento}", ticketID.getId_ticket(), ticketID.getAppuntamento().getId_appuntamento())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_ticket", is(ticket.getId_ticket().intValue())))
                .andExpect(jsonPath("$.appuntamento.id_appuntamento", is(ticket.getAppuntamento().getId_appuntamento().intValue())))
                .andExpect(jsonPath("$.stato", is(ticket.getStato())))
                .andExpect(jsonPath("$.paziente.id_paziente", is(ticket.getPaziente().getId_paziente().intValue())));
    }

    @Test
    public void testCreateTicket() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Chirurgo", paziente, medico);
        TicketDto ticket = new TicketDto(1L, appuntamento, 1000.0f, true, paziente);
        when(ticketService.createTicket(any(TicketDto.class))).thenReturn(ticket);

        mockMvc.perform(post("/api/tickets")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"Mario\",\"cognome\":\"Rossi\",\"dataNascita\":\"1990-01-01\",\"codiceFiscale\":\"RSSMRA90A01H501A\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id_ticket", is(ticket.getId_ticket().intValue())))
                .andExpect(jsonPath("$.appuntamento.id_appuntamento", is(ticket.getAppuntamento().getId_appuntamento().intValue())))
                .andExpect(jsonPath("$.stato", is(ticket.getStato())))
                .andExpect(jsonPath("$.paziente.id_paziente", is(ticket.getPaziente().getId_paziente().intValue())));
    }

    @Test
    public void testUpdateTicket() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Chirurgo", paziente, medico);
        TicketDto ticket = new TicketDto(1L, appuntamento, 1000.0f, true, paziente);
        when(ticketService.updateTicket(any(TicketID.class), any(TicketDto.class))).thenReturn(ticket);

        mockMvc.perform(put("/api/tickets/{id_ticket}/{id_appuntamento}", ticket.getId_ticket(), ticket.getAppuntamento().getId_appuntamento())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id_ticket\":1,\"nome\":\"Mario\",\"cognome\":\"Rossi\",\"data_n\":\"1990-01-01\",\"cf\":\"RSSMRA90A01H501A\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_ticket", is(ticket.getId_ticket().intValue())))
                .andExpect(jsonPath("$.appuntamento.id_appuntamento", is(ticket.getAppuntamento().getId_appuntamento().intValue())))
                .andExpect(jsonPath("$.stato", is(ticket.getStato())))
                .andExpect(jsonPath("$.paziente.id_paziente", is(ticket.getPaziente().getId_paziente().intValue())));
    }

    @Test
    public void testDeleteTicket() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-11-05"), "MRORSS90A01H501A", 1000.0f, "Cardiologia");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2021-01-01"), "Chirurgo", paziente, medico);
        TicketID ticketID = new TicketID(1L, appuntamento);
        
        doNothing().when(ticketService).deleteTicket(ticketID);

        mockMvc.perform(delete("/api/tickets/{id_ticket}/{id_appuntamento}", ticketID.getId_ticket(), ticketID.getAppuntamento().getId_appuntamento())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}