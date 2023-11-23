package idsa.progetto_idsa.dto;

import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Cartella;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RefertoDto { 
    private Long id_referto;
    private Appuntamento appuntamento;
    private String tipo_vis;
    private String prescr;
    private Cartella cartella;
}
