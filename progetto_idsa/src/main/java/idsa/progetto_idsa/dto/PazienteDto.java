package idsa.progetto_idsa.dto;

import java.sql.Date;
import java.util.List;

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
    private String nome;
    private String cognome;
    private Date data_n;
    private String cf;
    private List<Long> appuntamenti;
    private List<Long> ticket;
}