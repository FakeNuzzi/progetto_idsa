package idsa.progetto_idsa.dto;

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
    private Long appuntamento;

    private Float costo;
    private Boolean stato;
}