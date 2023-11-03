package idsa.progetto_idsa.entity;

import java.util.*;

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
    private List<Referto> referti = new ArrayList<Referto>();
}
