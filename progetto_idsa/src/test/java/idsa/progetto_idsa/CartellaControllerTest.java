package idsa.progetto_idsa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import idsa.progetto_idsa.dto.CartellaDto;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entity.Referto;
import idsa.progetto_idsa.entityID.CartellaID;
import idsa.progetto_idsa.service.CartellaService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureMockMvc
class CartellaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartellaService cartellaService;

    @Test
    public void testGetAllCartelle() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        CartellaDto cartellaDto = new CartellaDto(1L, paziente, referti);
        List<CartellaDto> cartelle = Collections.singletonList(cartellaDto);
        when(cartellaService.getAllCartelle()).thenReturn(cartelle);

        mockMvc.perform(get("/api/cartelle")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id_cartella", is(cartellaDto.getId_cartella().intValue())))
                .andExpect(jsonPath("$[0].paziente.id_paziente", is(cartellaDto.getPaziente().getId_paziente().intValue())))
                .andExpect(jsonPath("$[0].referti", is(cartellaDto.getReferti())));
    }
    
    @Test
    public void testGetCartellaById() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        CartellaDto cartella = new CartellaDto(1L, paziente, referti);
        CartellaID cartellaID = new CartellaID(1L, paziente);
        
        when(cartellaService.getCartellaById(any(CartellaID.class))).thenReturn(cartella);

        MvcResult result = mockMvc.perform(get("/api/cartelle/{id_cartella}/{id_paziente}", cartellaID.getId_cartella(), cartellaID.getPaziente().getId_paziente()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id_cartella", is(cartella.getId_cartella().intValue())))
            .andExpect(jsonPath("$.paziente.id_paziente", is(cartella.getPaziente().getId_paziente().intValue())))
            .andExpect(jsonPath("$.referti", is(cartella.getReferti())))
            .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    
    @Test
    public void testCreateCartella() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        CartellaDto cartella = new CartellaDto(1L, paziente, referti);
        when(cartellaService.createCartella(any(CartellaDto.class))).thenReturn(cartella);

        mockMvc.perform(post("/api/cartelle")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"Mario\",\"cognome\":\"Rossi\",\"dataNascita\":\"1990-01-01\",\"codiceFiscale\":\"RSSMRA90A01H501A\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id_cartella", is(cartella.getId_cartella().intValue())))
                .andExpect(jsonPath("$.paziente.id_paziente", is(cartella.getPaziente().getId_paziente().intValue())))
                .andExpect(jsonPath("$.referti", is(cartella.getReferti())));
    }

    @Test
    public void testUpdateCartella() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        List<Referto> referti = new ArrayList<Referto>();
        CartellaDto cartella = new CartellaDto(1L, paziente, referti);

        when(cartellaService.updateCartella(any(CartellaID.class), any(CartellaDto.class))).thenReturn(cartella);

        mockMvc.perform(put("/api/cartelle/{id_cartella}/{id_paziente}", cartella.getId_cartella(), cartella.getPaziente().getId_paziente())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id_cartella\":1,\"nome\":\"Mario\",\"cognome\":\"Rossi\",\"data_n\":\"1990-01-01\",\"cf\":\"RSSMRA90A01H501A\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_cartella", is(cartella.getId_cartella().intValue())))
                .andExpect(jsonPath("$.paziente.id_paziente", is(cartella.getPaziente().getId_paziente().intValue())))
                .andExpect(jsonPath("$.referti", is(cartella.getReferti())));
    }

    @Test
    public void testDeleteCartella() throws Exception {
        CartellaID cartellaID = new CartellaID(1L, new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A"));
        doNothing().when(cartellaService).deleteCartella(cartellaID);

        mockMvc.perform(delete("/api/cartelle/{id_cartella}/{id_paziente}", cartellaID.getId_cartella(), cartellaID.getPaziente().getId_paziente())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}