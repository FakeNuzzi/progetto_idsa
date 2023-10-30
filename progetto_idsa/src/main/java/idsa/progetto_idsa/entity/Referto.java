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
    private Long id_referto;
    @Column(name = "Referto visita", nullable = false)
    private String tipo_vis;
    @Column(name = "Prescrizione", nullable = false)
    private String prescr;
    @Id
    @Column(name = "id_cartella", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cartella")
    private Long paz;

}
