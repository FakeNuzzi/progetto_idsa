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

public class MedicoDto {
    private Long id_med;
    private String nome;
    private String cognome;
    private Date data_n;
    private String cf;
    private String email;
    private String password;
    private Float stipendio;
    private String specializ;
    private List<Long> id_appuntamenti;
    private List<String> tipi_visite;
}