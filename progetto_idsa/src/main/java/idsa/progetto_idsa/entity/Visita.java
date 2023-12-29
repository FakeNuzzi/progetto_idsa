package idsa.progetto_idsa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Visita")
public class Visita {
    @Id
    private String tipo_vis;
    @Column(name = "Descrizione", nullable = false)
    private String descr;
    @Column(name = "Prezzo", nullable = false)
    private Float prezzo;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @OneToOne
    @JoinColumn(name = "id_appuntamento")
    private Appuntamento appuntamento;
}
