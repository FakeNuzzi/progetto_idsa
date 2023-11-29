package idsa.progetto_idsa.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
public class SignupRequest {
    private String username;

    private String password;

    private String nome;

    private String cognome;

    private Date Data_n;

    private String cf;

    private Set<String> role;


}
