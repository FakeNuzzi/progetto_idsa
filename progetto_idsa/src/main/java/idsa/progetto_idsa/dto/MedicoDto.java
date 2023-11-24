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

public class MedicoDto { 
    private Long id_medico;
    private Float stipendio;
    private String specializ;
    private User user_id;
    //private List<Appuntamento> appuntamenti;
}