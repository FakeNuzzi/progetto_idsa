package idsa.progetto_idsa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user" )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_utente;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    //assumiamo che un utente posaavere piu ruoli
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "user_roles",joinColumns = @JoinColumn(name= "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


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

    public User(String email, String password, String nome, String cognome, Date data_n, String cf){
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.data_n = data_n;
        this.cf = cf;
    }

}
