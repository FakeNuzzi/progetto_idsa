package idsa.progetto_idsa.entity;

import java.util.Objects;

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
    @JoinColumn(name = "Paziente_Id", referencedColumnName = "id_paziente")
    private Paziente paziente;

    @Override
    public boolean equals(Object obj) {
        Ticket ticket = (Ticket) obj;
        if (this.id_ticket.equals(ticket.getId_ticket()) &&
                this.appuntamento.equals(ticket.getAppuntamento()) &&
                this.prezzo == ticket.getPrezzo() &&
                this.stato == ticket.getStato() &&
                this.paziente.equals(ticket.getPaziente())) {
            return true;
        } else
            return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id_ticket, appuntamento, prezzo, stato, paziente);
    }
}
