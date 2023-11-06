package idsa.progetto_idsa.dto;

import idsa.progetto_idsa.entity.Appuntamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TicketDto { 
    private Long id_ticket;
    private Appuntamento appuntamento;
    private Float prezzo;
    private Boolean stato;
}