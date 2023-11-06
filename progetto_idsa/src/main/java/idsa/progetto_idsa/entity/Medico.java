package idsa.progetto_idsa.entity;

import java.sql.Date;
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
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_medico;
    @Column(name = "Nome", nullable = false)
    private String nome;
    @Column(name = "Cognome", nullable = false)
    private String cognome;
    @Column(name = "Data di nascita", nullable = false)
    private Date data_n;
    @Column(name = "Codice Fiscale", nullable = false, unique = true)
    private String cf;
    @Column(name = "Stipendio", nullable = false)
    private Float stipendio;
    @Column(name = "Specializzazione", nullable = false, unique = true)
    private String specializ;

    /*
    @OneToMany
    private List<Appuntamento> appuntamenti = new ArrayList<Appuntamento>();
    */


    public Long getId_medico(){
        return this.id_medico;
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

    public Float getStipendio(){
        return this.stipendio;
    }

    public String getSpecializ(){
        return this.specializ;
    }
    /*
    public List<Long> getId_appuntamenti(){
        List<Long> id_appuntamenti = new ArrayList<Long>();
        for(int i=0; i<this.appuntamenti.size();i++){
            id_appuntamenti.add(this.appuntamenti.get(i).getId_appuntamento());
        }
        return id_appuntamenti;
    }
    */
}
