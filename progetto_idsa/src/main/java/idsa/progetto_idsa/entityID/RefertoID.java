package idsa.progetto_idsa.entityID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import idsa.progetto_idsa.entity.Appuntamento;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RefertoID implements Serializable {
    private Long id_referto;
    private Appuntamento appuntamento;
}