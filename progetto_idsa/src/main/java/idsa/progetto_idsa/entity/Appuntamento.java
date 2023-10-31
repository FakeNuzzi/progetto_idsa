package idsa.progetto_idsa.entity;

import java.sql.Date;

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
    private Long id_appuntamento;
    @Column(name = "Data e Ora", nullable = false)
    private Date data_n;
    @Column(name = "Tipo visita", nullable = false)
    private String tipo_visita;

    @OneToOne(mappedBy = "appuntamento")
    private Referto referto;

    @OneToOne(mappedBy = "appuntamento")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "Paziente_Id", referencedColumnName = "Id")
    private Paziente paziente;

    @ManyToOne
    @JoinColumn(name = "Medico_Id", referencedColumnName = "Id")
    private Medico medico;
}
