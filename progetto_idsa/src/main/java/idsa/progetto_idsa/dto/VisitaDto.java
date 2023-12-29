package idsa.progetto_idsa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VisitaDto {
    private String tipo_vis;
    private String descrizione;
    private Float prezzo;
    private Long id_medico;
    private Long id_appuntamento;
}