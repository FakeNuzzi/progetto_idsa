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

    @Id
    private Long id_paziente;
    @MapsId
    @OneToOne
    @JoinColumn(name = "Paziente_Id", referencedColumnName = "id_paziente")
    private Paziente paziente;

    @Column(name = "Lista Referti", nullable = false)
    private List<Long> list=new ArrayList<Long>();

    @OneToMany(mappedBy = "cartella")
    private List<Referto> referti;
}
