package idsa.progetto_idsa.entity;

import java.util.List;

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
public class Medico extends Utente {
    @Column(name = "Stipendio", nullable = false)
    private Float stipendio;
    @Column(name = "Specializzazione", nullable = false, unique = true)
    private String specializ;

    @OneToMany(mappedBy = "medico")
    private List<Appuntamento> appuntamenti;

    @OneToMany(mappedBy = "medico")
    private List<Visita> visite;
}
