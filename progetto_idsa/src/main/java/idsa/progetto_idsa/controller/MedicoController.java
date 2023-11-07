package idsa.progetto_idsa.controller;


import idsa.progetto_idsa.service.MedicoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medico")
@AllArgsConstructor
public class MedicoController {

    private MedicoService medicoService;
}
