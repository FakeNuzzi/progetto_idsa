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
@Table(name = "Paziente")
public class Paziente extends Utente{
    @OneToMany(mappedBy = "paziente")
    private List<Appuntamento> appuntamenti;

    public Paziente(Long id_utente, String nome, String cognome, java.sql.Date data_n, String cf, String email, String password, List<Appuntamento> appuntamenti) {
        super(id_utente, nome, cognome, data_n, cf, email, password);
        this.appuntamenti = appuntamenti;
    }

    public List<Long> getIdAppuntamenti() {
        List<Long> id_appuntamenti = new ArrayList<Long>();
        for(int i=0; i<appuntamenti.size(); i++) {
            id_appuntamenti.add(appuntamenti.get(i).getId_app());
        }   
        return id_appuntamenti;
    }
}
