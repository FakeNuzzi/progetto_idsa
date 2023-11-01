package idsa.progetto_idsa.entity;

import java.sql.Date;
import java.util.*;

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

    //@OneToOne(mappedBy = "Appuntamento_Id")
    //private Referto referto;

    //@OneToOne(mappedBy = "appuntamento_Id")
    //private Ticket ticket;

    //@ManyToOne
    //@JoinColumn(name = "Paziente_Id", referencedColumnName = "id_paziente")
    //private Paziente paziente;

    //@ManyToOne
    //@JoinColumn(name = "Medico_Id", referencedColumnName = "id_medico")
    //private Medico medico;
}
