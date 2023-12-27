package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.TicketDto;
import idsa.progetto_idsa.entityID.TicketID;

public interface TicketService {
    TicketDto createTicket(TicketDto ticketDto);
    TicketDto getTicketById(TicketID id_ticket);
    List<TicketDto> getAllTickets();
    TicketDto updateTicket(TicketID id_ticket, TicketDto updatedTicket);
    void deleteTicket(TicketID id_ticket);

    /*
    List<TicketDto> findByAppuntamento(AppuntamentoDto appuntamentoDto);
    List<TicketDto> findByPaziente(PazienteDto pazienteDto);
    */
}
