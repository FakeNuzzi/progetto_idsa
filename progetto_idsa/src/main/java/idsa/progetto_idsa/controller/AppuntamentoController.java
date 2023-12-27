package idsa.progetto_idsa.controller;

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

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.service.AppuntamentoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/api/appuntamenti")
public class AppuntamentoController {
    @Autowired
    private AppuntamentoService appuntamentoService;
    /*
    @Autowired
    private PazienteService pazienteService;
    @Autowired
    private MedicoService medicoService;
    */
    //ok
    @PostMapping
    public ResponseEntity<?> createAppuntamentoDto(@RequestBody AppuntamentoDto appuntamentoDto){
        AppuntamentoDto savedAppuntamento = appuntamentoService.createAppuntamento(appuntamentoDto);
        return new ResponseEntity<>(savedAppuntamento,HttpStatus.CREATED);
    }
    //ok
    @GetMapping
    public ResponseEntity<?> getAllAppuntamenti(){
        List<AppuntamentoDto> appuntamenti = appuntamentoService.getAllAppuntamenti();
        return ResponseEntity.ok(appuntamenti);
    }
    /*
    //ok
    @GetMapping("{idPaziente}")
    public ResponseEntity<?> getAppuntamentiByPaziente(@PathVariable("idPaziente")Long id_paziente){
        PazienteDto pazienteDto = pazienteService.getPazienteById(id_paziente);
        List<AppuntamentoDto> appuntamentoPazinete = appuntamentoService.findByPaziente(pazienteDto);
        return ResponseEntity.ok(appuntamentoPazinete);
    }
    //ok
    @GetMapping("{idMedico}")
    public ResponseEntity<?> getAppuntamentiByMedico(@PathVariable("idMedico")Long id_medico){
        MedicoDto medicoDto = medicoService.getMedicoById(id_medico);
        List<AppuntamentoDto> appuntamentoMedico = appuntamentoService.findByMedico(medicoDto);
        return ResponseEntity.ok(appuntamentoMedico);
    }
    */
    //ok
    @GetMapping("{idAppuntamento}")
    public ResponseEntity<?> getAppuntamentoById(@PathVariable("idAppuntamento")Long id_appuntamento){
        AppuntamentoDto appuntamentDto = appuntamentoService.getAppuntamentoById(id_appuntamento);
        return ResponseEntity.ok(appuntamentDto);
    }

    @PutMapping("{idAppuntamento}")
    public ResponseEntity<?> updateAppuntamento(@PathVariable("idAppuntamento")Long id_appuntamento, @RequestBody AppuntamentoDto updatedAppuntamento){
        AppuntamentoDto appuntamento = appuntamentoService.updateAppuntamento(id_appuntamento, updatedAppuntamento);
        return ResponseEntity.ok(appuntamento);
    }

    @DeleteMapping("{idAppuntamento}")
    public ResponseEntity<String> deleteAppuntamento(@PathVariable("idAppuntamento")Long id_appuntamento){
        appuntamentoService.deleteAppuntamento(id_appuntamento);
        return ResponseEntity.ok("Appuntamento cancellato con successo");
    }
}
