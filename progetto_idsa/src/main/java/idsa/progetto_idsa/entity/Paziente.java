package idsa.progetto_idsa.entity;

//import java.util.List;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Paziente")
public class Paziente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paziente;
    @Column(name = "Nome", nullable = false)
    private String nome;
    @Column(name = "Cognome", nullable = false)
    private String cognome;
    @Column(name = "Data di nascita", nullable = false)
    private Date data_n;
    @Column(name = "Codice Fiscale", nullable = false, unique = true)
    private String cf;


    @Override
    public boolean equals(Object obj) {
    if (this == obj) return true;
    Paziente paziente = (Paziente) obj;
    if (this.id_paziente.equals(paziente.getId_paziente()) &&
            this.nome.equals(paziente.getNome()) &&
            this.cognome.equals(paziente.getCognome()) &&
            this.data_n.equals(paziente.getData_n()) &&
            this.cf.equals(paziente.getCf())) {
            return true;
        } else
            return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id_paziente, nome, cognome, data_n, cf);
    }
}
