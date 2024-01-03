package idsa.progetto_idsa;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Date;

import org.junit.Test;
import org.mockito.Mockito;

import idsa.progetto_idsa.dto.SlotDto;
import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Slot;
import idsa.progetto_idsa.mapper.SlotMapper;
import idsa.progetto_idsa.repository.AppuntamentoRepository;

public class SlotMapperTest {
    @Test
    public void testMapToSlotDto() {
        Appuntamento a = new Appuntamento();
        a.setId_app(1L);
        Slot s = new Slot(1L, Date.valueOf("2021-01-01"), false);;
        SlotDto sDto = SlotMapper.mapToSlotDto(s);
        assertTrue(sDto.getDataOraSlot().equals(Date.valueOf("2021-01-01")));
        assertTrue(sDto.getOccupato().equals(false));
    }

    @Test
    public void testMapToSlot() {
        SlotDto sDto = new SlotDto(1L, Date.valueOf("2021-01-01"), false);;
        AppuntamentoRepository appuntamentoRepository = Mockito.mock(AppuntamentoRepository.class);
        Appuntamento a = new Appuntamento();
        a.setId_app(1L);
        
        when(appuntamentoRepository.findById(1L)).thenReturn(java.util.Optional.of(a));
        
        Slot s = SlotMapper.mapToSlot(sDto, appuntamentoRepository);
        assertTrue(s.getDataOraSlot().equals(Date.valueOf("2021-01-01")));
        assertTrue(s.getOccupato().equals(false));
    }

    @Test
    public void testSlotMapperConstructor() {
        SlotMapper slotMapper = new SlotMapper();
        assertTrue(slotMapper instanceof SlotMapper);
    }
}
