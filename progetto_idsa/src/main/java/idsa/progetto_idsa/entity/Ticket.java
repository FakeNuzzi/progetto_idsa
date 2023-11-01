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

    @Id
    private Long id_appuntamento;
    @MapsId
    @OneToOne
    @JoinColumn(name = "Appuntamento_Id", referencedColumnName = "id_appuntamento")
    private Appuntamento appuntamento;

    @Column(name = "Nome", nullable = false)
    private Float costo;
    @Column(name = "Stato", nullable = false)
    private Boolean stato;    

    @ManyToOne
    @JoinColumn(name = "Paziente_Id", referencedColumnName = "id_paziente")
    private Paziente paziente;


}
