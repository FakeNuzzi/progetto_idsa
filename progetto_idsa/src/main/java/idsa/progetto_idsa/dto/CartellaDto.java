package idsa.progetto_idsa.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CartellaDto { 
    private Long id_cartella;
    private Long id_paziente;
    private List<Long> id_referti;
}