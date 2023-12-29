package idsa.progetto_idsa.controller;


import idsa.progetto_idsa.dto.VisitaDto;
import idsa.progetto_idsa.service.VisitaService;
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

@RestController
@CrossOrigin("*")
@RequestMapping("/api/visite")
@AllArgsConstructor
public class VisitaController {
    private VisitaService visitaService;
    @PostMapping
    public ResponseEntity<VisitaDto> createVisita(@RequestBody VisitaDto visitaDto){
        VisitaDto savedVisita = visitaService.createVisita(visitaDto);
        return new ResponseEntity<>(savedVisita,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getVisitaById(@PathVariable("id")String tipo_vis){
        VisitaDto visitaDto = visitaService.getVisitaById(tipo_vis);
        return ResponseEntity.ok(visitaDto);
    }

    @GetMapping
    public ResponseEntity<List<VisitaDto>> getAllVisite(){
        List<VisitaDto> visite = visitaService.getAllVisite();
        return ResponseEntity.ok(visite);
    }

    @PutMapping("{id}")
    public ResponseEntity<VisitaDto> updateVisita(@PathVariable("id")String tipo_vis, @RequestBody VisitaDto updatedVisita){
        VisitaDto visitaDto = visitaService.updateVisita(tipo_vis, updatedVisita);
        return ResponseEntity.ok(visitaDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVisita(@PathVariable("id")String tipo_vis){
        visitaService.deleteVisita(tipo_vis);
        return ResponseEntity.ok("Visita cancellato con successo");
    }
}