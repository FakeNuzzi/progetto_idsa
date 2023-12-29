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
@Table(name = "Paziente")
public class Paziente extends Utente{
    @OneToMany(mappedBy = "paziente")
    private List<Appuntamento> appuntamenti;
}
