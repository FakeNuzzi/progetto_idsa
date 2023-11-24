package idsa.progetto_idsa.entity;

import idsa.progetto_idsa.entityID.PazienteID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(PazienteID.class)
@Entity
@Table(name = "Paziente")
public class Paziente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paziente;

    @OneToOne
    @JoinColumn(name = "user_Id", referencedColumnName = "id_utente")
    @MapsId
    private User user_id;

    /*
    @OneToOne(mappedBy = "paziente")
    private Cartella cartella;
    */

    /*
    @OneToMany
    private List<Appuntamento> appuntamenti;
    */

    /*
    @OneToMany
    private List<Ticket> tickets;
    */
}
