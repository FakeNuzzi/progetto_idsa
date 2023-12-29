package idsa.progetto_idsa.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AppuntamentoDto {
    private Long id_app;
    private Boolean pagato;
    private Long id_paziente;
    private Long id_medico;
    private Long id_risultato;
    private String tipo_visita;
    private Date dataOraSlot;

    public getPaziente() {
        return id_paziente;
    }
}
