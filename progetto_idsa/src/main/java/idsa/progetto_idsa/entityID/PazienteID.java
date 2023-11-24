package idsa.progetto_idsa.entityID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PazienteID implements Serializable{
    private Long id_paziente;
    private Long user_id;
}
