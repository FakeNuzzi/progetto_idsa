package idsa.progetto_idsa.dto;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Visita;
import idsa.progetto_idsa.repository.AppuntamentoRepository;
import idsa.progetto_idsa.repository.VisitaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MedicoDto {
    private Long id_utente;
    private String nome;
    private String cognome;
    private Date data_n;
    private String cf;
    private String email;
    private String password;
    private Float stipendio;
    private String specializ;
    private List<Long> id_appuntamenti;
    private List<String> tipi_visite;

    @Autowired
    AppuntamentoRepository appuntamentoRepository;
    @Autowired
    VisitaRepository visitaRepository;

    public MedicoDto(Long id_utente, String nome, String cognome, Date data_n, String cf, String email, String password, Float stipendio, String specializ, List<Long> id_appuntamenti, List<String> tipi_visite) {
        this.id_utente = id_utente;
        this.nome = nome;
        this.cognome = cognome;
        this.data_n = data_n;
        this.cf = cf;
        this.email = email;
        this.password = password;
        this.stipendio = stipendio;
        this.specializ = specializ;
        this.id_appuntamenti = id_appuntamenti;
        this.tipi_visite = tipi_visite;
    }

    public List<Appuntamento> getAppuntamenti() {
        List<Appuntamento> appuntamenti = appuntamentoRepository.findAllById(id_appuntamenti);
        return appuntamenti;
    }

    public List<Visita> getVisite() {
        List<Visita> visite = visitaRepository.findAllById(tipi_visite);
        return visite;
    }

}