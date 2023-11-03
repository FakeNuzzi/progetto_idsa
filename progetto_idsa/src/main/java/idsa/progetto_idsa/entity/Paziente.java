package idsa.progetto_idsa.entity;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

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
public class Paziente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paziente;
    @Column(name = "Nome", nullable = false)
    private String nome;
    @Column(name = "Cognome", nullable = false)
    private String cognome;
    @Column(name = "Data di nascita", nullable = false)
    private Date data_n;
    @Column(name = "Codice Fiscale", nullable = false, unique = true)
    private String cf;

    @OneToMany
    private List<Appuntamento> appuntamenti;

    @OneToMany
    private List<Ticket> tickets;

    public Long getId_paziente(){
        return this.id_paziente;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCognome(){
        return this.cognome;
    }

    public Date getData_n(){
        return this.data_n;
    }

    public String getCf(){
        return this.cf;
    }

    public List<Long> getId_appuntamenti(){
        List<Long> id_appuntamenti = new ArrayList<Long>();
        for(int i=0; i<this.appuntamenti.size();i++){
            id_appuntamenti.add(this.appuntamenti.get(i).getId_appuntamento());
        }
        return id_appuntamenti;
    }

    public List<Long> getId_tickets(){
        List<Long> id_tickets = new ArrayList<Long>();
        for(int i=0; i<this.tickets.size();i++){
            id_tickets.add(this.tickets.get(i).getId_ticket());
        }
        return id_tickets;
    }
}
