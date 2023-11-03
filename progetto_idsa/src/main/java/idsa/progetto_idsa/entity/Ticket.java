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

    @Column(name = "Costo", nullable = false)
    private Float prezzo;
    @Column(name = "Stato", nullable = false)
    private Boolean stato;

    /*
    @ManyToOne
    @JoinColumn(name = "Paziente_Id", referencedColumnName = "id_paziente")
    private Paziente paziente;
    */

    public Long getId_ticket(){
        return this.id_ticket;
    }

    public Float getPrezzo(){
        return this.prezzo;
    }

    public Boolean getBoolean(){
        return this.stato;
    }

    public Long getId_appuntamento(){
        return this.appuntamento.getId_appuntamento();
    }
}
