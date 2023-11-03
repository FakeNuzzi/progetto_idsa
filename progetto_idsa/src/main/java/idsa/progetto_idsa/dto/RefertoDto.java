package idsa.progetto_idsa.dto;

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
    private Long appuntamento;
    private String tipo_vis;
    private String prescr;
}
