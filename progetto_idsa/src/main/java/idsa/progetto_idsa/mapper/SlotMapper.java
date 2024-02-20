package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.dto.SlotDto;
import idsa.progetto_idsa.entity.Slot;
import idsa.progetto_idsa.repository.AppuntamentoRepository;

public class SlotMapper {
    public static SlotDto mapToSlotDto(Slot slot) {
        return new SlotDto(
            slot.getId_slot(),
            slot.getDataSlot(),
            slot.getOraSlot(),
            slot.getOccupato()
        );
    }

    public static Slot mapToSlot(SlotDto slotDto, AppuntamentoRepository appuntamentoRepository) {
        return new Slot(
            slotDto.getId_slot(),
            slotDto.getDataSlot(),
            slotDto.getOraSlot(),
            slotDto.getOccupato()
        );
    }
}