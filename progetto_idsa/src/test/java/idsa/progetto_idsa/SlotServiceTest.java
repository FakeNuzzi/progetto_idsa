package idsa.progetto_idsa;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import idsa.progetto_idsa.dto.SlotDto;
import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Slot;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.SlotMapper;
import idsa.progetto_idsa.repository.AppuntamentoRepository;
import idsa.progetto_idsa.repository.SlotRepository;
import idsa.progetto_idsa.service.impl.SlotServiceImpl;

public class SlotServiceTest {
        @Test
    public void testCreateSlot() {
        SlotRepository mockSlotRepository = mock(SlotRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        SlotServiceImpl slotService = new SlotServiceImpl(mockSlotRepository, mockAppuntamentoRepository);

        SlotDto slotDto = new SlotDto(1L, Date.valueOf("2021-01-01"), false);;
        
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        when(mockSlotRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        SlotDto result = slotService.createSlot(slotDto);

        verify(mockSlotRepository).save(any());
        
        assertTrue(result.getDataOraSlot().equals(slotDto.getDataOraSlot()));
        assertTrue(result.getOccupato().equals(slotDto.getOccupato()));    }

    @Test
    public void testGetSlotById() {
        SlotRepository mockSlotRepository = mock(SlotRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        SlotServiceImpl slotService = new SlotServiceImpl(mockSlotRepository, mockAppuntamentoRepository);

        SlotDto slotDto = new SlotDto(1L, Date.valueOf("2021-01-01"), false);;
   
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);        
        when(mockAppuntamentoRepository.findById(any())).thenReturn(Optional.of(mockAppuntamento));
        Slot mappedSlot = SlotMapper.mapToSlot(slotDto, mockAppuntamentoRepository);

        when(mockSlotRepository.findById(any())).thenReturn(Optional.of(mappedSlot));
        SlotDto result = slotService.getSlotById(1L);

        verify(mockSlotRepository).findById(1L);

        assertTrue(result.getDataOraSlot().equals(slotDto.getDataOraSlot()));
        assertTrue(result.getOccupato().equals(slotDto.getOccupato()));
    }

    @Test
    public void testGetAllSlots() {
        SlotRepository mockSlotRepository = mock(SlotRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        SlotServiceImpl slotService = new SlotServiceImpl(mockSlotRepository, mockAppuntamentoRepository);

        SlotDto slotDto = new SlotDto(1L, Date.valueOf("2021-01-01"), false);;

        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        
        Slot mappedSlot = SlotMapper.mapToSlot(slotDto, mockAppuntamentoRepository);
        List<Slot> mappedSlots = new ArrayList<>();
        mappedSlots.add(mappedSlot);
        when(mockSlotRepository.findAll()).thenReturn(mappedSlots);
        List<SlotDto> result = slotService.getAllSlots();

        verify(mockSlotRepository).findAll();

        assertTrue(result.get(0).getDataOraSlot().equals(slotDto.getDataOraSlot()));
        assertTrue(result.get(0).getOccupato().equals(slotDto.getOccupato()));
    }

    @Test
    public void testUpdateSlot() {
        SlotRepository mockSlotRepository = mock(SlotRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        SlotServiceImpl slotService = new SlotServiceImpl(mockSlotRepository, mockAppuntamentoRepository);

        SlotDto slotDto = new SlotDto(1L, Date.valueOf("2021-01-01"), false);;
        
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        
        Slot mappedSlot = SlotMapper.mapToSlot(slotDto, mockAppuntamentoRepository);
        when(mockSlotRepository.findById(any())).thenReturn(Optional.of(mappedSlot));
        when(mockSlotRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        SlotDto result = slotService.updateSlot(1L, slotDto);

        verify(mockSlotRepository).findById(any());

        assertTrue(result.getDataOraSlot().equals(slotDto.getDataOraSlot()));
        assertTrue(result.getOccupato().equals(slotDto.getOccupato()));
    }

    @Test
    public void testDeleteSlot() {
        SlotRepository mockSlotRepository = mock(SlotRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        SlotServiceImpl slotService = new SlotServiceImpl(mockSlotRepository, mockAppuntamentoRepository);

        SlotDto slotDto = new SlotDto(1L, Date.valueOf("2021-01-01"), false);;;
        
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        
        Slot mappedSlot = SlotMapper.mapToSlot(slotDto, mockAppuntamentoRepository);
        when(mockSlotRepository.findById(any())).thenReturn(Optional.of(mappedSlot));

        slotService.deleteSlot(1L);

        verify(mockSlotRepository).deleteById(1L);
    }

    @Test
    public void testGetSlotByIdSlotNotFound() {
        SlotRepository mockSlotRepository = mock(SlotRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        SlotServiceImpl slotService = new SlotServiceImpl(mockSlotRepository, mockAppuntamentoRepository);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockSlotRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            slotService.getSlotById(1L);
        });
    }

    @Test
    public void testUpdateSlotNotFound() {
        SlotRepository mockSlotRepository = mock(SlotRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        SlotServiceImpl slotService = new SlotServiceImpl(mockSlotRepository, mockAppuntamentoRepository);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockSlotRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            slotService.updateSlot(1L, new SlotDto());
        });
    }
}
