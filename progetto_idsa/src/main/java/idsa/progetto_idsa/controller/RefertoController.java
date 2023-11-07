package idsa.progetto_idsa.controller;

import idsa.progetto_idsa.dto.RefertoDto;
import idsa.progetto_idsa.service.RefertoService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/referto")
@AllArgsConstructor
public class RefertoController {

    private RefertoService refertoService;
    @PostMapping
    public ResponseEntity<RefertoDto> createReferto(@RequestBody RefertoDto refertoDto){
        RefertoDto savedReferto = refertoService.createReferto(refertoDto);
        return new ResponseEntity<>(savedReferto,HttpStatus.CREATED);
    }
}
