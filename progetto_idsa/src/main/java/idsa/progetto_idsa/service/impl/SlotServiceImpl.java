package idsa.progetto_idsa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idsa.progetto_idsa.dto.SlotDto;
import idsa.progetto_idsa.entity.Slot;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.SlotMapper;
import idsa.progetto_idsa.repository.SlotRepository;
import idsa.progetto_idsa.service.SlotService;

@Service
public class SlotServiceImpl implements SlotService {
    @Autowired
    private SlotRepository slotRepository;

    @Override
    public SlotDto createSlot(SlotDto slotDto) {
        Slot slot = SlotMapper.mapToSlot(slotDto);
        Slot savedSlot = slotRepository.save(slot);
        return SlotMapper.mapToSlotDto(savedSlot);
    }
    
    @Override
    public SlotDto getSlotById(Date dataOraSlot){
        Slot slot = slotRepository.findById(dataOraSlot)
            .orElseThrow(() -> new ResourceNotFoundException("Slot non esiste per l'id dato : " + dataOraSlot));
            return SlotMapper.mapToSlotDto(slot);
    }

    @Override
    public List<SlotDto> getAllSlots(){
        List<Slot> slots = slotRepository.findAll();
        return slots.stream().map((slot) -> SlotMapper.mapToSlotDto(slot))
            .collect(Collectors.toList());
    }

    @Override
    public SlotDto updateSlot(Date dataOraSlot, SlotDto updatedSlot){
        Slot slot = slotRepository.findById(dataOraSlot)
            .orElseThrow(() -> new ResourceNotFoundException("Slot non esiste per l'id dato : " + dataOraSlot));
        slot.setOccupato(updatedSlot.getOccupato());
        slot.setAppuntamento(updatedSlot.getAppuntamento());

        Slot updatedSlotObj = slotRepository.save(slot);

        return SlotMapper.mapToSlotDto(updatedSlotObj);
    }

    @Override
    public void deleteSlot(Date dataOraSlot){
        slotRepository.findById(dataOraSlot)
            .orElseThrow(() -> new ResourceNotFoundException("Slot non esiste per l'id dato : " + dataOraSlot));
        slotRepository.deleteById(dataOraSlot);
    }
}