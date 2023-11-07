package idsa.progetto_idsa.controller;

import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.service.PazienteService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paziente")
@AllArgsConstructor
public class PazienteController {
    private PazienteService pazienteService;
    @PostMapping
    public ResponseEntity<PazienteDto> createPaziente(@RequestBody PazienteDto pazienteDto){
        PazienteDto savedPaziente = pazienteService.createPaziente(pazienteDto);
        return new ResponseEntity<>(savedPaziente,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PazienteDto> getPazienteById(@PathVariable("id")Long id_paziente){
        PazienteDto appuntamentDto = pazienteService.getPazienteById(id_paziente);
        return ResponseEntity.ok(appuntamentDto);
    }
}
