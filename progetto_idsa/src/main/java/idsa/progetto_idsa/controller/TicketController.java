package idsa.progetto_idsa.controller;

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.dto.RefertoDto;
import idsa.progetto_idsa.dto.TicketDto;
import idsa.progetto_idsa.entityID.TicketID;
import idsa.progetto_idsa.service.AppuntamentoService;
import idsa.progetto_idsa.service.PazienteService;
import idsa.progetto_idsa.service.TicketService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tickets")
@AllArgsConstructor
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private AppuntamentoService appuntamentoService;
    @Autowired
    private PazienteService pazienteService;
    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto){
        TicketDto savedTicket = ticketService.createTicket(ticketDto);
        return new ResponseEntity<>(savedTicket,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable("id")TicketID id_ticket){
        TicketDto appuntamentDto = ticketService.getTicketById(id_ticket);
        return ResponseEntity.ok(appuntamentDto);
    }

    @GetMapping
    public ResponseEntity<List<TicketDto>> getAllTickets(){
        List<TicketDto> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @PutMapping("{id}")
    public ResponseEntity<TicketDto> updateTicket(@PathVariable("id")TicketID id_ticket, @RequestBody TicketDto updatedTicket){
        TicketDto ticketDto = ticketService.updateTicket(id_ticket, updatedTicket);
        return ResponseEntity.ok(ticketDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable("id")TicketID id_ticket){
        ticketService.deleteTicket(id_ticket);
        return ResponseEntity.ok("Ticket cancellato con successo");
    }

    @GetMapping("{idAppuntamento}")
    public ResponseEntity<?> getTicketByAppuntamento(@PathVariable("idAppuntamento")Long id_appuntamento){
        AppuntamentoDto appuntamentoDto = appuntamentoService.getAppuntamentoById(id_appuntamento);
        List<TicketDto> ticketAppuntamento = ticketService.findByAppuntamento(appuntamentoDto);
        return ResponseEntity.ok(ticketAppuntamento);
    }

    @GetMapping("{idPaziente}")
    public ResponseEntity<?> getTicketByPaziente(@PathVariable("idPazient")Long id_paziente){
        PazienteDto pazienteDto = pazienteService.getPazienteById(id_paziente);
        List<TicketDto> ticketPaziente = ticketService.findByPaziente(pazienteDto);
        return ResponseEntity.ok(ticketPaziente);
    }
}
