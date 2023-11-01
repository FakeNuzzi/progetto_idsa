package idsa.progetto_idsa.entity;

import idsa.progetto_idsa.entityID.RefertoID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(RefertoID.class)
@Entity
@Table(name = "Referto")
public class Referto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_referto;
    @Id
    private Long id_appuntamento;
    @MapsId
    @OneToOne
    @JoinColumn(name = "Appuntamento_Id", referencedColumnName = "id_appuntamento")
    private Appuntamento appuntamento;

    @Column(name = "Referto_visita", nullable = false)
    private String tipo_vis;
    @Column(name = "Prescrizione", nullable = false)
    private String prescr;
    
    @ManyToOne
    @JoinColumn(name = "Cartella_Id", referencedColumnName = "id_cartella")
    private Cartella cartella;
}