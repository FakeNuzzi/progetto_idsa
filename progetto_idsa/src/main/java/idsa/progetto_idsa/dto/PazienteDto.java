package idsa.progetto_idsa.dto;

import idsa.progetto_idsa.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PazienteDto { 
    private Long id_paziente;
    private User user_id;
    //private List<Ticket> tickets;
}