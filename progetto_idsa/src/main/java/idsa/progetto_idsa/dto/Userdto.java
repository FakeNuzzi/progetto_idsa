package idsa.progetto_idsa.dto;

import idsa.progetto_idsa.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Userdto {
    private String email;
    private String password;

    private Role role;
    private Boolean attivo;
    private String nome;
    private String cognome;
    private Date data_n;
    private String cf;



}
