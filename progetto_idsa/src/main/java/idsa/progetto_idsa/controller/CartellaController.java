package idsa.progetto_idsa.controller;

import idsa.progetto_idsa.dto.CartellaDto;
import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entityID.CartellaID;
import idsa.progetto_idsa.service.CartellaService;
import idsa.progetto_idsa.service.PazienteService;
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

    @Autowired
    private PazienteService pazienteService;

    @PostMapping
    public ResponseEntity<CartellaDto> createCartella(@RequestBody CartellaDto cartellaDto){
        CartellaDto savedCartella = cartellaService.createCartella(cartellaDto);
        return new ResponseEntity<>(savedCartella,HttpStatus.CREATED);
    }

    @GetMapping("{id_cartella}/{id_paziente}")
    public ResponseEntity<CartellaDto> getCartellaById(@PathVariable("id_cartella")Long id_cartella, @PathVariable("id_paziente")Long id_paziente){
        PazienteDto pazienteDto = pazienteService.getPazienteById(id_paziente);
        Paziente paziente = new Paziente(pazienteDto.getId_paziente(), pazienteDto.getNome(), pazienteDto.getCognome(), pazienteDto.getData_n(), pazienteDto.getCf());
        CartellaID cartellaID = new CartellaID(id_cartella, paziente);
        CartellaDto cartellaDto = cartellaService.getCartellaById(cartellaID);
        return ResponseEntity.ok(cartellaDto);
    }

    @GetMapping
    public ResponseEntity<List<CartellaDto>> getAllCartelle(){
        List<CartellaDto> cartelle = cartellaService.getAllCartelle();
        return ResponseEntity.ok(cartelle);
    }

    @PutMapping("{id_cartella}/{id_paziente}")
    public ResponseEntity<CartellaDto> updateCartella(@PathVariable("id_cartella")Long id_cartella, @PathVariable("id_paziente")Long id_paziente, @RequestBody CartellaDto updatedCartella){
        PazienteDto pazienteDto = pazienteService.getPazienteById(id_paziente);
        Paziente paziente = new Paziente(pazienteDto.getId_paziente(), pazienteDto.getNome(), pazienteDto.getCognome(), pazienteDto.getData_n(), pazienteDto.getCf());
        CartellaID cartellaID = new CartellaID(id_cartella, paziente);
        CartellaDto cartellaDto = cartellaService.updateCartella(cartellaID, updatedCartella);
        return ResponseEntity.ok(cartellaDto);
    }

    @DeleteMapping("{id_cartella}/{id_paziente}")
    public ResponseEntity<String> deleteCartella(@PathVariable("id_cartella")Long id_cartella, @PathVariable("id_paziente")Long id_paziente){
        PazienteDto pazienteDto = pazienteService.getPazienteById(id_paziente);
        Paziente paziente = new Paziente(pazienteDto.getId_paziente(), pazienteDto.getNome(), pazienteDto.getCognome(), pazienteDto.getData_n(), pazienteDto.getCf());
        CartellaID cartellaID = new CartellaID(id_cartella, paziente);
        cartellaService.deleteCartella(cartellaID);
        return ResponseEntity.ok("Cartella cancellata con successo");
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
