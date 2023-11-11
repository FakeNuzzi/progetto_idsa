package idsa.progetto_idsa.entity;

import java.util.Collection;
import java.util.List;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Paziente")
public class Paziente implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paziente;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "Nome", nullable = false)
    private String nome;
    @Column(name = "Cognome", nullable = false)
    private String cognome;
    @Column(name = "Data di nascita", nullable = false)
    private Date data_n;
    @Column(name = "Codice Fiscale", nullable = false, unique = true)
    private String cf;
    @Column(name = "Attivo", nullable = false, unique = true)
    private boolean attivo;

    private Role ruolo;

    //@OneToOne(mappedBy = "paziente")
    //private Cartella cartella;

    @OneToMany
    private List<Appuntamento> appuntamenti;

    @OneToMany
    private List<Ticket> ticket;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return attivo;
    }

    @Override
    public boolean isAccountNonLocked() {
        return attivo;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return attivo;
    }

    @Override
    public boolean isEnabled() {
        return attivo;
    }
}
