package idsa.progetto_idsa.entity;

import java.util.List;

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
public class Paziente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paziente;

    @OneToOne
    @JoinColumn(name = "user_Id", referencedColumnName = "id_utente")
    @MapsId
    private User user_Id;
    //@OneToOne(mappedBy = "paziente")
    //private Cartella cartella;

    @OneToMany
    private List<Appuntamento> appuntamenti;

    @OneToMany
    private List<Ticket> ticket;

}
