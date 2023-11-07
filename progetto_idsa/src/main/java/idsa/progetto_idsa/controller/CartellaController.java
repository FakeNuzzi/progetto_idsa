package idsa.progetto_idsa.controller;

import idsa.progetto_idsa.service.CartellaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cartella")
@AllArgsConstructor
public class CartellaController {

    private CartellaService cartellaService;

}
