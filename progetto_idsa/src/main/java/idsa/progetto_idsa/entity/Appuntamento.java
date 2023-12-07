package idsa.progetto_idsa.entity;

import java.sql.Date;
import java.util.Objects;

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
@Table(name = "Appuntamento")
public class Appuntamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_appuntamento;
    @Column(name = "Data e Ora", nullable = false)
    private Date data;
    @Column(name = "Tipo visita", nullable = false)
    private String tipo_visita;
    
    @ManyToOne
    @JoinColumn(name = "Paziente_Id", referencedColumnName = "id_paziente")
    private Paziente paziente;
    
    @ManyToOne
    @JoinColumn(name = "Medico_Id", referencedColumnName = "id_medico")
    private Medico medico;

    /*
    public Long getId_Paziente(){
        return paziente.getId_paziente();
    }

    public Long getId_Medico(){
        return medico.getId_medico();
    }
    */

    @Override
    public boolean equals(Object obj) {
    Appuntamento appuntamento = (Appuntamento) obj;
    if (this.id_appuntamento.equals(appuntamento.getId_appuntamento()) &&
            this.data.equals(appuntamento.getData()) &&
            this.tipo_visita.equals(appuntamento.getTipo_visita()) &&
            this.paziente.equals(appuntamento.getPaziente()) &&
            this.medico.equals(appuntamento.getMedico())) {
            return true;
        } else
            return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id_appuntamento, data, tipo_visita, paziente, medico);
    }
}
