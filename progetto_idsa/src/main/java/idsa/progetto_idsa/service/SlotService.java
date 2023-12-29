package idsa.progetto_idsa.service;

import java.sql.Date;
import java.util.List;

import idsa.progetto_idsa.dto.SlotDto;

public interface SlotService {
    SlotDto createSlot(SlotDto pazienteDto);
    SlotDto getSlotById(Date dataOraSlot);
    List<SlotDto> getAllSlots();
    SlotDto updateSlot(Date dataOraSlot, SlotDto updatedSlot);
    void deleteSlot(Date dataOraSlot);
}