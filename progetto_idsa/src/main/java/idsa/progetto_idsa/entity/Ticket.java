package idsa.progetto_idsa.entity;

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
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ticket;
    
    @JoinColumn(name = "Appuntamento")
    @OneToOne
    @MapsId
    private Appuntamento appuntamento;

    @Column(name = "Nome", nullable = false)
    private Float costo;
    @Column(name = "Stato", nullable = false)
    private Boolean stato;    

    @ManyToOne
    @JoinColumn(name = "Paziente_Id", referencedColumnName = "id_paziente")
    private Paziente paziente;


}
