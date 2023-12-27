package idsa.progetto_idsa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.service.PazienteService;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
class PazienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PazienteService pazienteService;

    @Test
    public void testGetAllAppuntamenti() throws Exception {
        PazienteDto pazienteDto = new PazienteDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        List<PazienteDto> pazienti = Collections.singletonList(pazienteDto);
        when(pazienteService.getAllPazienti()).thenReturn(pazienti);

        mockMvc.perform(get("/api/pazienti")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id_paziente", is(pazienteDto.getId_paziente().intValue())))
                .andExpect(jsonPath("$[0].nome", is(pazienteDto.getNome())))
                .andExpect(jsonPath("$[0].cognome", is(pazienteDto.getCognome())))
                .andExpect(jsonPath("$[0].data_n", is(pazienteDto.getData_n().toString())))
                .andExpect(jsonPath("$[0].cf", is(pazienteDto.getCf())));
    }

    @Test
    public void testGetPazienteById() throws Exception {
        PazienteDto paziente = new PazienteDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        when(pazienteService.getPazienteById(1L)).thenReturn(paziente);

        mockMvc.perform(get("/api/pazienti/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_paziente", is(paziente.getId_paziente().intValue())))
                .andExpect(jsonPath("$.nome", is(paziente.getNome())))
                .andExpect(jsonPath("$.cognome", is(paziente.getCognome())))
                .andExpect(jsonPath("$.data_n", is(paziente.getData_n().toString())))
                .andExpect(jsonPath("$.cf", is(paziente.getCf())));
    }

    @Test
    public void testCreatePaziente() throws Exception {
        PazienteDto paziente = new PazienteDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        when(pazienteService.createPaziente(any(PazienteDto.class))).thenReturn(paziente);

        mockMvc.perform(post("/api/pazienti")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"Mario\",\"cognome\":\"Rossi\",\"dataNascita\":\"1990-01-01\",\"codiceFiscale\":\"RSSMRA90A01H501A\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id_paziente", is(paziente.getId_paziente().intValue())))
                .andExpect(jsonPath("$.nome", is(paziente.getNome())))
                .andExpect(jsonPath("$.cognome", is(paziente.getCognome())))
                .andExpect(jsonPath("$.data_n", is(paziente.getData_n().toString())))
                .andExpect(jsonPath("$.cf", is(paziente.getCf())));
    }

    @Test
    public void testUpdatePaziente() throws Exception {
        PazienteDto paziente = new PazienteDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        when(pazienteService.updatePaziente(any(Long.class), any(PazienteDto.class))).thenReturn(paziente);

        mockMvc.perform(put("/api/pazienti/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id_paziente\":1,\"nome\":\"Mario\",\"cognome\":\"Rossi\",\"data_n\":\"1990-01-01\",\"cf\":\"RSSMRA90A01H501A\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_paziente", is(paziente.getId_paziente().intValue())))
                .andExpect(jsonPath("$.nome", is(paziente.getNome())))
                .andExpect(jsonPath("$.cognome", is(paziente.getCognome())))
                .andExpect(jsonPath("$.data_n", is(new SimpleDateFormat("yyyy-MM-dd").format(paziente.getData_n())))) // Ensure the date format matches
                .andExpect(jsonPath("$.cf", is(paziente.getCf())));
    }

    @Test
    public void testDeletePaziente() throws Exception {
        doNothing().when(pazienteService).deletePaziente(1L);

        mockMvc.perform(delete("/api/pazienti/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}