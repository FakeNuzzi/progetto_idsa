package idsa.progetto_idsa.controller;

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.dto.CartellaDto;
import idsa.progetto_idsa.dto.RefertoDto;

import idsa.progetto_idsa.entityID.CartellaID;
import idsa.progetto_idsa.entityID.RefertoID;
import idsa.progetto_idsa.service.AppuntamentoService;
import idsa.progetto_idsa.service.CartellaService;
import idsa.progetto_idsa.service.RefertoService;
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
@RequestMapping("/api/referti")
@AllArgsConstructor
public class RefertoController {
    @Autowired
    private RefertoService refertoService;
    @Autowired
    private AppuntamentoService appuntamentoService;
    @Autowired
    private CartellaService cartellaService;
    @PostMapping
    public ResponseEntity<RefertoDto> createReferto(@RequestBody RefertoDto refertoDto){
        RefertoDto savedReferto = refertoService.createReferto(refertoDto);
        return new ResponseEntity<>(savedReferto,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RefertoDto> getRefertoById(@PathVariable("id")RefertoID id_referto){
        RefertoDto refertDto = refertoService.getRefertoById(id_referto);
        return ResponseEntity.ok(refertDto);
    }

    @GetMapping
    public ResponseEntity<List<RefertoDto>> getAllReferti(){
        List<RefertoDto> referti = refertoService.getAllReferti();
        return ResponseEntity.ok(referti);
    }

    @PutMapping("{id}")
    public ResponseEntity<RefertoDto> updateReferto(@PathVariable("id")RefertoID id_referto, @RequestBody RefertoDto updatedReferto){
        RefertoDto refertoDto = refertoService.updateReferto(id_referto, updatedReferto);
        return ResponseEntity.ok(refertoDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteReferto(@PathVariable("id")RefertoID id_referto){
        refertoService.deleteReferto(id_referto);
        return ResponseEntity.ok("Referto cancellato con successo");
    }

    @GetMapping("{idAppuntamento}")
    public ResponseEntity<?> getRefertoByAppuntamento(@PathVariable("idAppuntamento")Long id_appuntamento){
        AppuntamentoDto appuntamentoDto = appuntamentoService.getAppuntamentoById(id_appuntamento);
        List<RefertoDto> refertoAppuntamento = refertoService.findByAppuntamento(appuntamentoDto);
        return ResponseEntity.ok(refertoAppuntamento);
    }

    @GetMapping("{idCartella}")
    public ResponseEntity<?> getRefertoByCartella(@PathVariable("idCartella") CartellaID id_cartella){
        CartellaDto cartellaDto = cartellaService.getCartellaById(id_cartella);
        List<RefertoDto> refertoAppuntamento = refertoService.findByCartella(cartellaDto);
        return ResponseEntity.ok(refertoAppuntamento);
    }
}
