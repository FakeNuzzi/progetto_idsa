package idsa.progetto_idsa.controller;

import idsa.progetto_idsa.service.RefertoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/referto")
@AllArgsConstructor
public class RefertoController {

    private RefertoService refertoService;
}
