package idsa.progetto_idsa.dto;

import java.sql.Date;

import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AppuntamentoDto { 
    private Long id_appuntamento;
    private Date data;
    private String tipo_visita;
    private Paziente paziente;
    private Medico medico;

}