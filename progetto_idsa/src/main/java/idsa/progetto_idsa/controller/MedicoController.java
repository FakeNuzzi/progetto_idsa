package idsa.progetto_idsa.controller;


import idsa.progetto_idsa.dto.MedicoDto;
import idsa.progetto_idsa.service.MedicoService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medico")
@AllArgsConstructor
public class MedicoController {
    private MedicoService medicoService;
    @PostMapping
    public ResponseEntity<MedicoDto> createMedico(@RequestBody MedicoDto medicoDto){
        MedicoDto savedMedico = medicoService.createMedico(medicoDto);
        return new ResponseEntity<>(savedMedico,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MedicoDto> getMedicoById(@PathVariable("id")Long id_medico){
        MedicoDto medicDto = medicoService.getMedicoById(id_medico);
        return ResponseEntity.ok(medicDto);
    }

    @GetMapping
    public ResponseEntity<List<MedicoDto>> getAllMedici(){
        List<MedicoDto> medici = medicoService.getAllMedici();
        return ResponseEntity.ok(medici);
    }

    @PutMapping("{id}")
    public ResponseEntity<MedicoDto> updateMedico(@PathVariable("id")Long id_medico, @RequestBody MedicoDto updatedMedico){
        MedicoDto medicoDto = medicoService.updateMedico(id_medico, updatedMedico);
        return ResponseEntity.ok(medicoDto);
    }
}
