package idsa.progetto_idsa.entity;

import java.util.*;

import idsa.progetto_idsa.entityID.CartellaID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CartellaID.class)
@Entity
@Table(name = "Cartella")
public class Cartella {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartella_seq")
    @SequenceGenerator(name = "cartella_seq", sequenceName = "cartella_seq", allocationSize = 1)
    private Long id_cartella;

    @OneToOne
    @JoinColumn(name = "Paziente", referencedColumnName = "id_paziente")
    @MapsId
    private Paziente paziente;

    @OneToMany
    private List<Referto> referti;
    //private List<Referto> referti = new ArrayList<Referto>();

    @Override
    public boolean equals(Object obj) {
        Cartella cartella = (Cartella) obj;
        if (cartella.getId_cartella().equals(this.id_cartella) &&
                cartella.getPaziente().equals(this.paziente) &&
                cartella.getReferti().equals(this.referti)) {
            return true;
        } else
            return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id_cartella, paziente, referti);
    }
}
