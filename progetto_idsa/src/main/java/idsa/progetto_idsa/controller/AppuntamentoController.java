package idsa.progetto_idsa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("{id}")
    public ResponseEntity<AppuntamentoDto> getAppuntamentoById(@PathVariable("id")Long id_appuntamento){
        AppuntamentoDto appuntamentDto = appuntamentoService.getAppuntamentoById(id_appuntamento);
        return ResponseEntity.ok(appuntamentDto);
    }

    @GetMapping
    public ResponseEntity<List<AppuntamentoDto>> getAllAppuntamenti(){
        List<AppuntamentoDto> appuntamenti = appuntamentoService.getAllAppuntamenti();
        return ResponseEntity.ok(appuntamenti);
    }

    @PutMapping("{id}")
    public ResponseEntity<AppuntamentoDto> updateAppuntamento(@PathVariable("id")Long id_appuntamento, @RequestBody AppuntamentoDto updatedAppuntamento){
        AppuntamentoDto appuntamentoDto = appuntamentoService.updateAppuntamento(id_appuntamento, updatedAppuntamento);
        return ResponseEntity.ok(appuntamentoDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAppuntamento(@PathVariable("id")Long id_appuntamento){
        appuntamentoService.deleteAppuntamento(id_appuntamento);
        return ResponseEntity.ok("Appuntamento cancellato con successo");
    }
}
