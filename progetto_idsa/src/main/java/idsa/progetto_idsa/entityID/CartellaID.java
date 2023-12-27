package idsa.progetto_idsa.entityID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import idsa.progetto_idsa.entity.Paziente;
import jakarta.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class CartellaID implements Serializable {
    private Long id_cartella;
    private Paziente paziente;
}