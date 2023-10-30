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
@Table(name = "Prenota")
public class Prenota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paziente;
    @Id
    private Long id_appuntamento;
}
