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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cartella;

    @OneToOne
    @JoinColumn(name = "Paziente", referencedColumnName = "id_paziente")
    @MapsId
    private Paziente paziente;

    @OneToMany
    private List<Referto> referti;
    //private List<Referto> referti = new ArrayList<Referto>();
}
