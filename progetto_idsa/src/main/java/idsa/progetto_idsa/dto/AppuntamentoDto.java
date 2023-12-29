package idsa.progetto_idsa.dto;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entity.Risultato;
import idsa.progetto_idsa.entity.Slot;
import idsa.progetto_idsa.entity.Visita;
import idsa.progetto_idsa.repository.MedicoRepository;
import idsa.progetto_idsa.repository.PazienteRepository;
import idsa.progetto_idsa.repository.RisultatoRepository;
import idsa.progetto_idsa.repository.SlotRepository;
import idsa.progetto_idsa.repository.VisitaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AppuntamentoDto {
    private Long id_app;
    private Boolean pagato;
    private Long id_paziente;
    private Long id_medico;
    private Long id_risultato;
    private String tipo_visita;
    private Date dataOraSlot;

    @Autowired
    PazienteRepository pazienteRepository;
    @Autowired
    MedicoRepository medicoRepository;
    @Autowired
    RisultatoRepository risultatoRepository;
    @Autowired
    VisitaRepository visitaRepository;
    @Autowired
    SlotRepository slotRepository;

    public AppuntamentoDto(Long id_app, Boolean pagato, Long id_paziente, Long id_medico, Long id_risultato, String tipo_visita, Date dataOraSlot) {
        this.pagato = pagato;
        this.id_paziente = id_paziente;
        this.id_medico = id_medico;
        this.id_risultato = id_risultato;
        this.tipo_visita = tipo_visita;
        this.dataOraSlot = dataOraSlot;
    }

    public Paziente getPaziente() {
        return pazienteRepository.findById(id_paziente).get();
    }

    public Medico getMedico() {
        return medicoRepository.findById(id_medico).get();
    }

    public Risultato getRisultato() {
        return risultatoRepository.findById(id_risultato).get();
    }

    public Visita getVisita() {
        return visitaRepository.findById(tipo_visita).get();
    }

    public Slot getSlot() {
        return slotRepository.findById(dataOraSlot).get();
    }
}
