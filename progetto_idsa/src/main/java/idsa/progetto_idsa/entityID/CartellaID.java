package idsa.progetto_idsa.entityID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import idsa.progetto_idsa.entity.Paziente;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CartellaID implements Serializable {
    private Long id_cartella;
    private Paziente paziente;
}
