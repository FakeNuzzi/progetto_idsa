package idsa.progetto_idsa.dto;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.repository.AppuntamentoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PazienteDto {
    private Long id_utente;
    private String nome;
    private String cognome;
    private Date data_n;
    private String cf;
    private String email;
    private String password;
    private List<Long> id_appuntamenti;

    @Autowired
    AppuntamentoRepository appuntamentoRepository;

    public PazienteDto(Long id_utente, String nome, String cognome, Date data_n, String cf, String email, String password, List<Long> id_appuntamenti) {
        this.id_utente = id_utente;
        this.nome = nome;
        this.cognome = cognome;
        this.data_n = data_n;
        this.cf = cf;
        this.email = email;
        this.password = password;
        this.id_appuntamenti = id_appuntamenti;
    }

    public List<Appuntamento> getAppuntamenti() {
        List<Appuntamento> appuntamenti = appuntamentoRepository.findAllById(id_appuntamenti);
        return appuntamenti;
    }
}