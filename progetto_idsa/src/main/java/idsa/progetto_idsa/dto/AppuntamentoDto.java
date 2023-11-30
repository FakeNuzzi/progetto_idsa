package idsa.progetto_idsa.dto;

import java.sql.Date;

import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.repository.MedicoRepository;
import idsa.progetto_idsa.repository.PazienteRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AppuntamentoDto {
    private Long id_appuntamento;
    private Date data;
    private String tipo_visita;
    private Paziente paziente;
    private Medico medico;
    /*
    private Long paziente_id;
    private Long medico_id;

    PazienteRepository pazienteRepository;
    MedicoRepository medicoRepository;

    public void setPaziente(Paziente paziente){
        this.paziente_id = paziente.getId_paziente();
    }

    public Paziente getPaziente(){
        return pazienteRepository.findById(paziente_id).get();
    }

    public void setMedico(Medico medico){
        this.medico_id = medico.getId_medico();
    }

    public Medico getMedico(){
        return medicoRepository.findById(medico_id).get();
    }
    */
}