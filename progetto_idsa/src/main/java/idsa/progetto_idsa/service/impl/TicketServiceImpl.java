package idsa.progetto_idsa.service.impl;

import idsa.progetto_idsa.dto.TicketDto;
import idsa.progetto_idsa.entity.Ticket;
import idsa.progetto_idsa.mapper.TicketMapper;
import idsa.progetto_idsa.repository.TicketRepository;
import idsa.progetto_idsa.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    @Override
    public TicketDto createTicket(TicketDto ticketDto) {

        Ticket ticket = TicketMapper.mapToTicket(ticketDto);
        Ticket savedTicket = ticketRepository.save(ticket);
        return TicketMapper.mapToTicketDto(savedTicket);
    }
}
