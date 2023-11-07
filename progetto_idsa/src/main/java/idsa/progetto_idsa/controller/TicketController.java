package idsa.progetto_idsa.controller;

import idsa.progetto_idsa.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticket")
@AllArgsConstructor
public class TicketController {

    private TicketService ticketService;
}
