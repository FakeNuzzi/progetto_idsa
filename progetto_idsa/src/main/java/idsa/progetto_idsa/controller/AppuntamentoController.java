package idsa.progetto_idsa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.service.AppuntamentoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/appuntamenti")
public class AppuntamentoController {
    private AppuntamentoService appuntamentoService;
    @PostMapping
    public ResponseEntity<AppuntamentoDto> createAppuntamento(@RequestBody AppuntamentoDto appuntamentoDto){
        AppuntamentoDto savedAppuntamento = appuntamentoService.createAppuntamento(appuntamentoDto);
        return new ResponseEntity<>(savedAppuntamento,HttpStatus.CREATED);
    }
}
