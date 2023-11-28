package idsa.progetto_idsa.entity;

import jakarta.persistence.*;
import lombok.*;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users" )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_utente;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;

    //assumiamo che un utente posaavere piu ruoli
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "role_user",joinColumns = @JoinColumn(name= "utente"),inverseJoinColumns = @JoinColumn(name = "role"))
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

    public User(String username, String password, String nome, String cognome, Date data_n, String cf){
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.data_n = data_n;
        this.cf = cf;
    }

}
