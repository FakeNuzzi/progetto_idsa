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
@Table(name = "Referto")
public class Referto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Referto visita", nullable = false)
    private String tipo_vis;
    @Column(name = "Prescrizione", nullable = false)
    private String prescr;

    @OneToOne
    @JoinColumn(name = "Appuntamento_Id", referencedColumnName = "Id")
    private Appuntamento appuntamento;

    @ManyToOne
    @JoinColumn(name = "Cartella_Id", referencedColumnName = "Id")
    private Cartella cartella;
}
