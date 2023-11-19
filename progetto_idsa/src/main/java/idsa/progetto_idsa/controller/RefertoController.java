package idsa.progetto_idsa.controller;

import idsa.progetto_idsa.dto.RefertoDto;

import idsa.progetto_idsa.entityID.RefertoID;
import idsa.progetto_idsa.service.RefertoService;
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
@RequestMapping("/api/referti")
@AllArgsConstructor
public class RefertoController {

    private RefertoService refertoService;
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
}
