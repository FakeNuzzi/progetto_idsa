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
@Table(name = "Appuntamento")
public class Appuntamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_app;
    @Column(name = "Pagato", nullable = false)
    private Boolean pagato;

    @ManyToOne
    @JoinColumn(name = "id_paziente")
    private Paziente paziente;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @OneToOne
    @JoinColumn(name = "id_risultato")
    private Risultato risultato;

    @OneToOne
    @JoinColumn(name = "tipo_visita")
    private Visita visita;

    @OneToOne
    @JoinColumn(name = "data_slot")
    private Slot slot;
}
