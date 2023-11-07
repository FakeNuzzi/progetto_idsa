package idsa.progetto_idsa.service;

import idsa.progetto_idsa.dto.TicketDto;
import idsa.progetto_idsa.entityID.TicketID;

public interface TicketService {
    TicketDto createTicket(TicketDto ticketDto);
    TicketDto getTicketById(TicketID id_ticket);
}
