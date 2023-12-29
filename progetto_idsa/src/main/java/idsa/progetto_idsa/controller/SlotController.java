package idsa.progetto_idsa.controller;


import idsa.progetto_idsa.dto.SlotDto;
import idsa.progetto_idsa.service.SlotService;
import lombok.AllArgsConstructor;

import java.sql.Date;
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
@RequestMapping("/api/slots")
@AllArgsConstructor
public class SlotController {
    private SlotService slotService;
    @PostMapping
    public ResponseEntity<SlotDto> createSlot(@RequestBody SlotDto slotDto){
        SlotDto savedSlot = slotService.createSlot(slotDto);
        return new ResponseEntity<>(savedSlot,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getSlotById(@PathVariable("id")Date dataOraSlot){
        SlotDto slotDto = slotService.getSlotById(dataOraSlot);
        return ResponseEntity.ok(slotDto);
    }

    @GetMapping
    public ResponseEntity<List<SlotDto>> getAllSlots(){
        List<SlotDto> slots = slotService.getAllSlots();
        return ResponseEntity.ok(slots);
    }

    @PutMapping("{id}")
    public ResponseEntity<SlotDto> updateSlot(@PathVariable("id")Date dataOraSlot, @RequestBody SlotDto updatedSlot){
        SlotDto slotDto = slotService.updateSlot(dataOraSlot, updatedSlot);
        return ResponseEntity.ok(slotDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSlot(@PathVariable("id")Date dataOraSlot){
        slotService.deleteSlot(dataOraSlot);
        return ResponseEntity.ok("Slot cancellato con successo");
    }
}