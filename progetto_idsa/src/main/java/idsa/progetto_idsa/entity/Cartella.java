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
    @Id
    @Column(name = "Paziente", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paziente")
    private Long id_paziente;
    @Column(name = "Lista Referti", nullable = false)
    private List<Long> list=new ArrayList<Long>();

    @OneToOne
    @JoinColumn(name = "Paziente_Id", referencedColumnName = "Id")
    private Paziente paziente;

    @OneToMany(mappedBy = "cartella")
    private List<Referto> referti;
}
