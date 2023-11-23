package idsa.progetto_idsa.entity;

// import java.util.List;

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
@Table(name = "Medico")
public class Medico{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_medico;
    @Column(name = "Stipendio", nullable = false)
    private Float stipendio;
    @Column(name = "Specializzazione", nullable = false, unique = true)
    private String specializ;

    @OneToOne
    @JoinColumn(name = "Utente_Id", referencedColumnName = "id_utente")
    private User user_id;

    /*
    @OneToMany
    private List<Appuntamento> appuntamenti;
    */

}
