package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.dto.SlotDto;
import idsa.progetto_idsa.entity.Slot;

public class SlotMapper {
    public static SlotDto mapToSlotDto(Slot slot) {
        return new SlotDto(
            slot.getDataOraSlot(),
            slot.getOccupato(),
            slot.getAppuntamento().getId_app()
        );
    }

    public static Slot mapToSlot(SlotDto slotDto) {
        return new Slot(
            slotDto.getDataOraSlot(),
            slotDto.getOccupato(),
            slotDto.getAppuntamento()
        );
    }
}