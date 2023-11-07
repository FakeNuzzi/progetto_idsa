package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.entity.Ticket;
import idsa.progetto_idsa.dto.TicketDto;

public class TicketMapper{
    public static TicketDto mapToTicketDto(Ticket ticket){
        return new TicketDto(
            ticket.getId_ticket(),
            ticket.getAppuntamento(),
            ticket.getPrezzo(),
            ticket.getStato(),
            ticket.getPaziente()
        );
    }
    
    public static Ticket mapToTicket(TicketDto ticketDto){
        return new Ticket(
            ticketDto.getId_ticket(),
            ticketDto.getAppuntamento(),
            ticketDto.getPrezzo(),
            ticketDto.getStato(),
            ticketDto.getPaziente()
        );
    }
}