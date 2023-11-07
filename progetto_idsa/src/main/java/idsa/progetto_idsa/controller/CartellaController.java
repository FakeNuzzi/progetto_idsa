package idsa.progetto_idsa.controller;

import idsa.progetto_idsa.dto.CartellaDto;
import idsa.progetto_idsa.entityID.CartellaID;
import idsa.progetto_idsa.service.CartellaService;
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
@RequestMapping("/api/cartella")
@AllArgsConstructor
public class CartellaController {
    private CartellaService cartellaService;
    @PostMapping
    public ResponseEntity<CartellaDto> createCartella(@RequestBody CartellaDto cartellaDto){
        CartellaDto savedCartella = cartellaService.createCartella(cartellaDto);
        return new ResponseEntity<>(savedCartella,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CartellaDto> getCartellaById(@PathVariable("id")CartellaID id_cartella){
        CartellaDto appuntamentDto = cartellaService.getCartellaById(id_cartella);
        return ResponseEntity.ok(appuntamentDto);
    }
}
