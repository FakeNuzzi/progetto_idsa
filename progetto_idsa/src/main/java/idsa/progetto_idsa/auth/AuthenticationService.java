package idsa.progetto_idsa.auth;

import idsa.progetto_idsa.config.JwtService;
import idsa.progetto_idsa.dto.LoginDto;
import idsa.progetto_idsa.dto.UserDto;
import idsa.progetto_idsa.entity.Role;
import idsa.progetto_idsa.entity.User;
import idsa.progetto_idsa.exception.ApiException;
import idsa.progetto_idsa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final Role role;

    //ok
    public String register(UserDto request){
        if(repository.existsByEmail(request.getEmail())){
            throw new ApiException(HttpStatus.BAD_REQUEST, "email gia in uso");
        }

        var user = User.builder()
                .nome(request.getNome())
                .cognome(request.getCognome())
                .email(request.getEmail())
                .data_n(request.getData_n())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .cf(request.getCf())
                .attivo(request.getAttivo())
                .build();

        repository.save(user);

        return "user registered successfully";

        /*
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
        */
    }
    //ok;
    public AuthenticationResponse authenticate(LoginDto request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);



        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken((UserDetails) user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();


    }
}
