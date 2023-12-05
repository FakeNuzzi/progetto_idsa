package idsa.progetto_idsa.dto;

import java.sql.Date;

import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
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
    private Long id_paziente;
    private Long id_medico;

    @Autowired
    private PazienteRepository pazienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    public AppuntamentoDto(Long id_appuntamento, Date data, String tipo_visita, Long id_paziente, Long id_medico){
        this.id_appuntamento = id_appuntamento;
        this.data = data;
        this.tipo_visita = tipo_visita;
        this.id_paziente = id_paziente;
        this.id_medico = id_medico;
    }

    public Paziente getPaziente(){
        return pazienteRepository.findById(id_paziente).get();
    }

    public Medico getMedico(){
        return medicoRepository.findById(id_medico).get();
    }
    */
}