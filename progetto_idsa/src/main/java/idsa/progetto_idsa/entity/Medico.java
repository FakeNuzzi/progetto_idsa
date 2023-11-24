package idsa.progetto_idsa.entity;

import idsa.progetto_idsa.entityID.MedicoID;

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
@IdClass(MedicoID.class)
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
    @JoinColumn(name = "user_Id", referencedColumnName = "id_utente")
    @MapsId
    private User user_id;

}
