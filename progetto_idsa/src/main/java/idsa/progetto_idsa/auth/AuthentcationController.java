package idsa.progetto_idsa.auth;

import idsa.progetto_idsa.dto.Logindto;
import idsa.progetto_idsa.dto.Userdto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthentcationController {


    private final AuthenticationService service;
    //ok
    @PostMapping("/register")
    public ResponseEntity <String> Register(
          @RequestBody  Userdto userdto
    ){
        String response = service.register(userdto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/authenticate")
    public ResponseEntity <AuthenticationResponse> Register(
           @RequestBody Logindto request
    ){
        AuthenticationResponse response =  service.authenticate(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
