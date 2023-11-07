package idsa.progetto_idsa.controller;

import idsa.progetto_idsa.service.PazienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paziente")
@AllArgsConstructor
public class PazinteController {

    private PazienteService pazienteService;
}
