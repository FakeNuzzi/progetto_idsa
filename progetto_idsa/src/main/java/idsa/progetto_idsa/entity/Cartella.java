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
    private CartellaID id_cartella;

    @Column(name = "Lista Referti", nullable = false)
    private List<Long> list=new ArrayList<Long>();

    @OneToOne
    @Id
    @JoinColumn(name = "Paziente_Id", referencedColumnName = "id_paziente")
    private Paziente paziente;

    @OneToMany(mappedBy = "cartella")
    private List<Referto> referti;
}
