package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.SlotDto;

public interface SlotService {
    SlotDto createSlot(SlotDto pazienteDto);
    SlotDto getSlotById(Long id_slot);
    List<SlotDto> getAllSlots();
    SlotDto updateSlot(Long id_slot, SlotDto updatedSlot);
    void deleteSlot(Long id_slot);
    List <SlotDto> getSlotsNotOccupied();
}