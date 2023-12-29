package idsa.progetto_idsa.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "Medico")
public class Medico extends Utente {
    @Column(name = "Stipendio", nullable = false)
    private Float stipendio;
    @Column(name = "Specializzazione", nullable = false, unique = true)
    private String specializ;

    @OneToMany(mappedBy = "medico")
    private List<Appuntamento> appuntamenti;

    @OneToMany(mappedBy = "medico")
    private List<Visita> visite;

    public Medico(Long id_utente, String nome, String cognome, java.sql.Date data_n, String cf, String email, String password, Float stipendio, String specializ, List<Appuntamento> appuntamenti, List<Visita> visite) {
        super(id_utente, nome, cognome, data_n, cf, email, password);
        this.stipendio = stipendio;
        this.specializ = specializ;
        this.appuntamenti = appuntamenti;
        this.visite = visite;
    }

    public List<Long> getIdAppuntamenti() {
        List<Long> id_appuntamenti = new ArrayList<Long>();
        for(int i=0; i<appuntamenti.size(); i++) {
            id_appuntamenti.add(appuntamenti.get(i).getId_app());
        }   
        return id_appuntamenti;
    }

    public List<String> getTipiVisite() {
        List<String> tipi_visite = new ArrayList<String>();
        for(int i=0; i<visite.size(); i++) {
            tipi_visite.add(visite.get(i).getTipo_vis());
        }   
        return tipi_visite;
    }
}
