package idsa.progetto_idsa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_utente;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @OneToOne
    @JoinColumn(name = "role", referencedColumnName = "id_ruolo")
    //assicurati che allo 0 corrisponda l utente con menoprivilegi di tutti
    @Column(columnDefinition = "integer default 0")
    private Role role;
    @Column(name = "attivo", columnDefinition = "boolean default true")
    private Boolean attivo;

    @Column(name = "Nome", nullable = false)
    private String nome;
    @Column(name = "Cognome", nullable = false)
    private String cognome;
    @Column(name = "Data di nascita", nullable = false)
    private Date data_n;
    @Column(name = "Codice Fiscale", nullable = false, unique = true)
    private String cf;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getName()));
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
