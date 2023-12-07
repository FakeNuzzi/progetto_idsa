package idsa.progetto_idsa.entity;


import java.util.Objects;

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
    
    @ManyToOne
    @JoinColumn(name = "Cartella_Id", referencedColumnName = "id_cartella")
    private Cartella cartella;

    @Override
    public boolean equals(Object obj) {
        Referto referto = (Referto) obj;
        if (referto.getId_referto().equals(this.id_referto) &&
                referto.getAppuntamento().equals(this.appuntamento) &&
                referto.getTipo_vis().equals(this.tipo_vis) &&
                referto.getPrescr().equals(this.prescr) &&
                referto.getCartella().equals(this.cartella)) {
            return true;
        } else
            return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id_referto, appuntamento, tipo_vis, prescr, cartella);
    }
    
}
