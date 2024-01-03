package idsa.progetto_idsa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idsa.progetto_idsa.dto.SlotDto;
import idsa.progetto_idsa.entity.Slot;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.SlotMapper;
import idsa.progetto_idsa.repository.AppuntamentoRepository;
import idsa.progetto_idsa.repository.SlotRepository;
import idsa.progetto_idsa.service.SlotService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SlotServiceImpl implements SlotService {
    @Autowired
    private SlotRepository slotRepository;
    @Autowired
    private AppuntamentoRepository appuntamentoRepository;

    @Override
    public SlotDto createSlot(SlotDto slotDto) {
        Slot slot = SlotMapper.mapToSlot(slotDto, appuntamentoRepository);
        Slot savedSlot = slotRepository.save(slot);
        return SlotMapper.mapToSlotDto(savedSlot);
    }
    
    @Override
    public SlotDto getSlotById(Long id_slot){
        Slot slot = slotRepository.findById(id_slot)
            .orElseThrow(() -> new ResourceNotFoundException("Slot not found"));
            return SlotMapper.mapToSlotDto(slot);
    }

    @Override
    public List<SlotDto> getAllSlots(){
        List<Slot> slots = slotRepository.findAll();
        return slots.stream().map((slot) -> SlotMapper.mapToSlotDto(slot))
            .collect(Collectors.toList());
    }

    @Override
    public SlotDto updateSlot(Long id_slot, SlotDto updatedSlot){
        Slot slot = slotRepository.findById(id_slot)
            .orElseThrow(() -> new ResourceNotFoundException("Slot not found"));
        slot.setOccupato(updatedSlot.getOccupato());
        Slot updatedSlotObj = slotRepository.save(slot);

        return SlotMapper.mapToSlotDto(updatedSlotObj);
    }

    @Override
    public void deleteSlot(Long id_slot){
        slotRepository.findById(id_slot);
        slotRepository.deleteById(id_slot);
    }
}