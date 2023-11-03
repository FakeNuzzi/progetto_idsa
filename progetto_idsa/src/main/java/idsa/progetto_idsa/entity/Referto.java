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
    @OneToOne
    @JoinColumn(name = "Appuntamento", referencedColumnName = "id_appuntamento")
    @MapsId
    private Appuntamento appuntamento;

    @Column(name = "Referto_visita", nullable = false)
    private String tipo_vis;
    @Column(name = "Prescrizione", nullable = true)
    private String prescr;

    /*
    @ManyToOne
    @JoinColumn(name = "Cartella_Id", referencedColumnName = "id_cartella")
    private Cartella cartella;
    */

    public Long getId_referto(){
        return this.id_referto;
    }

    public String getTipo_vis(){
        return this.tipo_vis;
    }

    public String getPrescr(){
        return this.prescr;
    }

    public Long getId_appuntamento(){
        return this.appuntamento.getId_appuntamento();
    }
    
}
