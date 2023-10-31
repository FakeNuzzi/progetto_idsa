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
    private Long id;
    @Column(name = "Nome", nullable = false)
    private Float costo;
    
    @OneToOne
    @JoinColumn(name = "Appuntamento_Id", referencedColumnName = "Id")
    private Appuntamento appuntamento;

    @ManyToOne
    @JoinColumn(name = "Paziente_Id", referencedColumnName = "Id")
    private Paziente paziente;
}
