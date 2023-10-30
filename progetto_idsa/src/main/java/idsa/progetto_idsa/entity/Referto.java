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
@Table(name = "Referto")
public class Referto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Appuntamento", nullable = false)
    private Long appunt;
    @Column(name = "Data e Ora", nullable = false)
    private Date data_n;
    @Column(name = "Tipo visita", nullable = false)
    private String tipo_visita;
}
