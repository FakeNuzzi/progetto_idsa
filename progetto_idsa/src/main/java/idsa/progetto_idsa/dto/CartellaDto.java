package idsa.progetto_idsa.dto;

import java.util.List;

import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entity.Referto;

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
    private Paziente paziente;
    private List<Referto> referti;
}