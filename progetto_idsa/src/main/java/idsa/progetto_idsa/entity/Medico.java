package idsa.progetto_idsa.entity;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Medico")
public class Medico implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_medico;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "passwrd", nullable = false)
    private String password;
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
    @Column(name = "attivo", nullable = false, unique = true)
    private boolean attivo;


    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    private List<Appuntamento> appuntamenti;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
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
