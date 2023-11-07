package idsa.progetto_idsa.service.impl;

import idsa.progetto_idsa.dto.TicketDto;
import idsa.progetto_idsa.entity.Ticket;
import idsa.progetto_idsa.entityID.TicketID;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.TicketMapper;
import idsa.progetto_idsa.repository.TicketRepository;
import idsa.progetto_idsa.service.TicketService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public TicketDto getTicketById(TicketID id_ticket){
        Ticket ticket = ticketRepository.findById(id_ticket)
            .orElseThrow(() -> new ResourceNotFoundException("Ticket non esiste per un dato id : " + id_ticket));
            return TicketMapper.mapToTicketDto(ticket);
    }

    @Override
    public List<TicketDto> getAllTickets(){
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream().map((ticket) -> TicketMapper.mapToTicketDto(ticket))
            .collect(Collectors.toList());
    }
}
