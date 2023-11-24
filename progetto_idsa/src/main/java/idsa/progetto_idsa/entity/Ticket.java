package idsa.progetto_idsa.entity;

import idsa.progetto_idsa.entityID.TicketID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(TicketID.class)
@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ticket;
    @OneToOne
    @JoinColumn(name = "Appuntamento", referencedColumnName = "id_appuntamento")
    @MapsId
    private Appuntamento appuntamento;

    @Column(name = "Prezzo", nullable = false)
    private Float prezzo;
    @Column(name = "Stato", nullable = false)
    private Boolean stato;

    @ManyToOne
    @JoinColumn(name = "PazienteID", referencedColumnName = "id_paziente")
    private Paziente paziente;
}
