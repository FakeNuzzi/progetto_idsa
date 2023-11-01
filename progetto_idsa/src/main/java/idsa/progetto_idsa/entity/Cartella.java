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

    @JoinColumn(name = "Paziente")
    @OneToOne
    @MapsId
    private Paziente paziente;

    @Column(name = "Lista Referti", nullable = false)
    private List<Long> list=new ArrayList<Long>();

    @OneToMany(mappedBy = "cartella")
    private List<Referto> referti;
}
