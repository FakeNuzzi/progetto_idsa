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
    @Column(name = "costo", nullable = false)
    private Float costo;
    @Id
    @Column(name = "id_appuntamento", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_appuntamento")
    private Long id_appuntamento;

}
