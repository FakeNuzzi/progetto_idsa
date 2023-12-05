package idsa.progetto_idsa.entity;

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
@Table(name = "Medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_medico;
    @Column(name = "Nome", nullable = false)
    private String nome;
    @Column(name = "Cognome", nullable = false)
    private String cognome;
    @Column(name = "Data di nascita", nullable = false)
    private Date data_n;
    @Column(name = "Codice Fiscale", nullable = false, unique = true)
    private String cf;
    @Column(name = "Stipendio", nullable = false)
    private Float stipendio;
    @Column(name = "Specializzazione", nullable = false, unique = true)
    private String specializ;

    @Override
    public boolean equals(Object obj) {
    Medico medico = (Medico) obj;
    if (this.id_medico.equals(medico.getId_medico()) &&
            this.nome.equals(medico.getNome()) &&
            this.cognome.equals(medico.getCognome()) &&
            this.data_n.equals(medico.getData_n()) &&
            this.cf.equals(medico.getCf()) &&
            this.stipendio.equals(medico.getStipendio()) &&
            this.specializ.equals(medico.getSpecializ())) {
            return true;
        } else
            return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id_medico, nome, cognome, data_n, cf, stipendio, specializ);
    }
}
