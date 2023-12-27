package idsa.progetto_idsa.controller;

import idsa.progetto_idsa.dto.CartellaDto;
import idsa.progetto_idsa.entityID.CartellaID;
import idsa.progetto_idsa.service.CartellaService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/cartelle")
@AllArgsConstructor
public class CartellaController {
    @Autowired
    private CartellaService cartellaService;

    @PostMapping
    public ResponseEntity<CartellaDto> createCartella(@RequestBody CartellaDto cartellaDto){
        CartellaDto savedCartella = cartellaService.createCartella(cartellaDto);
        return new ResponseEntity<>(savedCartella,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CartellaDto> getCartellaById(@PathVariable("id")CartellaID cartellaID){
        CartellaDto cartellaDto = cartellaService.getCartellaById(cartellaID);
        return ResponseEntity.ok(cartellaDto);
    }

    @GetMapping
    public ResponseEntity<List<CartellaDto>> getAllCartelle(){
        List<CartellaDto> cartelle = cartellaService.getAllCartelle();
        return ResponseEntity.ok(cartelle);
    }

    @PutMapping("{id}")
    public ResponseEntity<CartellaDto> updateCartella(@PathVariable("id")CartellaID id_cartella, @RequestBody CartellaDto updatedCartella){
        CartellaDto cartellaDto = cartellaService.updateCartella(id_cartella, updatedCartella);
        return ResponseEntity.ok(cartellaDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCartella(@PathVariable("id")CartellaID id_cartella){
        cartellaService.deleteCartella(id_cartella);
        return ResponseEntity.ok("Cartella cancellato con successo");
    }

    /*
    @GetMapping("{idPaziente}")
    public ResponseEntity<?> getCartellaByPaziente(@PathVariable("idPaziente")Long id_paziente){
        PazienteDto pazienteDto = pazienteService.getPazienteById(id_paziente);
        List<CartellaDto> cartellaPazinete = cartellaService.findByPaziente(pazienteDto);
        return ResponseEntity.ok(cartellaPazinete);
    }
    */
}
