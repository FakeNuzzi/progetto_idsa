package idsa.progetto_idsa.controller;


import idsa.progetto_idsa.dto.MedicoDto;
import idsa.progetto_idsa.service.MedicoService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
