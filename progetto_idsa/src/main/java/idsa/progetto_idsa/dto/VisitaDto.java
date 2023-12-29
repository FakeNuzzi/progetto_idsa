package idsa.progetto_idsa.dto;

import org.springframework.beans.factory.annotation.Autowired;

import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.repository.AppuntamentoRepository;
import idsa.progetto_idsa.repository.MedicoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VisitaDto {
    private String tipo_vis;
    private String descr;
    private Float prezzo;
    private Long id_medico;
    private Long id_appuntamento;

    @Autowired
    MedicoRepository medicoRepository;
    @Autowired
    AppuntamentoRepository appuntamentoRepository;

    public VisitaDto(String tipo_vis, String descr, Float prezzo, Long id_medico, Long id_appuntamento) {
        this.tipo_vis = tipo_vis;
        this.descr = descr;
        this.prezzo = prezzo;
        this.id_medico = id_medico;
        this.id_appuntamento = id_appuntamento;
    }

    public Medico getMedico() {
        Medico medico = medicoRepository.findById(id_medico).get();
        return medico;
    }

    public Appuntamento getAppuntamento() {
        Appuntamento appuntamento = appuntamentoRepository.findById(id_appuntamento).get();
        return appuntamento;
    }
}