package idsa.progetto_idsa.entity;

import java.sql.Date;

import idsa.progetto_idsa.repository.MedicoRepository;
import idsa.progetto_idsa.repository.PazienteRepository;
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

    @ManyToOne()
    @JoinColumn(name = "Paziente_Id", referencedColumnName = "id_paziente")
    private Paziente paziente;
    
    @ManyToOne
    @JoinColumn(name = "Medico_Id", referencedColumnName = "id_medico")
    private Medico medico;

    /*
    PazienteRepository pazienteRepository;
    MedicoRepository medicoRepository;

    public void setPaziente(Long paziente_id){
        this.paziente = pazienteRepository.findById(paziente_id).get();
    }

    public Long getPaziente(){
        return this.paziente.getId_paziente();
    }

    public void setMedico(Long medico_id){
        this.medico = medicoRepository.findById(medico_id).get();
    }

    public Long getMedico(){
        return this.medico.getId_medico();
    }
    */
}
