package idsa.progetto_idsa.dto;

import idsa.progetto_idsa.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id_utente;
    private String username;
    private String password;

    private Set<Role> roles = new HashSet<>();
    private Boolean attivo;
    private String nome;
    private String cognome;
    private Date data_n;
    private String cf;



}
