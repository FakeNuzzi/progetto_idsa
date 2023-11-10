package idsa.progetto_idsa.controller;

import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.service.PazienteService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
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
        PazienteDto pazienteDto = pazienteService.getPazienteById(id_paziente);
        return ResponseEntity.ok(pazienteDto);
    }

    @GetMapping
    public ResponseEntity<List<PazienteDto>> getAllPazienti(){
        List<PazienteDto> pazienti = pazienteService.getAllPazienti();
        return ResponseEntity.ok(pazienti);
    }

    @PutMapping("{id}")
    public ResponseEntity<PazienteDto> updatePaziente(@PathVariable("id")Long id_paziente, @RequestBody PazienteDto updatedPaziente){
        PazienteDto pazienteDto = pazienteService.updatePaziente(id_paziente, updatedPaziente);
        return ResponseEntity.ok(pazienteDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePaziente(@PathVariable("id")Long id_paziente){
        pazienteService.deletePaziente(id_paziente);
        return ResponseEntity.ok("Paziente cancellato con successo");
    }
}
