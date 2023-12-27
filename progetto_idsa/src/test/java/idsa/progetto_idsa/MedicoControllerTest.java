package idsa.progetto_idsa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import idsa.progetto_idsa.dto.MedicoDto;
import idsa.progetto_idsa.service.MedicoService;

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
class MedicoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicoService medicoService;

    @Test
    public void testGetAllAppuntamenti() throws Exception {
        MedicoDto medicoDto = new MedicoDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Medico di base");
        List<MedicoDto> medici = Collections.singletonList(medicoDto);
        when(medicoService.getAllMedici()).thenReturn(medici);

        mockMvc.perform(get("/api/medici")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id_medico", is(medicoDto.getId_medico().intValue())))
                .andExpect(jsonPath("$[0].nome", is(medicoDto.getNome())))
                .andExpect(jsonPath("$[0].cognome", is(medicoDto.getCognome())))
                .andExpect(jsonPath("$[0].data_n", is(medicoDto.getData_n().toString())))
                .andExpect(jsonPath("$[0].cf", is(medicoDto.getCf())))
                .andExpect(jsonPath("$[0].stipendio", is(medicoDto.getStipendio().doubleValue())))
                .andExpect(jsonPath("$[0].specializ", is(medicoDto.getSpecializ())));
    }

    @Test
    public void testGetMedicoById() throws Exception {
        MedicoDto medico = new MedicoDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Medico di base");
        when(medicoService.getMedicoById(1L)).thenReturn(medico);

        mockMvc.perform(get("/api/medici/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_medico", is(medico.getId_medico().intValue())))
                .andExpect(jsonPath("$.nome", is(medico.getNome())))
                .andExpect(jsonPath("$.cognome", is(medico.getCognome())))
                .andExpect(jsonPath("$.data_n", is(medico.getData_n().toString())))
                .andExpect(jsonPath("$.cf", is(medico.getCf())))
                .andExpect(jsonPath("$.stipendio", is(medico.getStipendio().doubleValue())))
                .andExpect(jsonPath("$.specializ", is(medico.getSpecializ())));
    }

    @Test
    public void testCreateMedico() throws Exception {
        MedicoDto medico = new MedicoDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Medico di base");
        when(medicoService.createMedico(any(MedicoDto.class))).thenReturn(medico);

        mockMvc.perform(post("/api/medici")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"Mario\",\"cognome\":\"Rossi\",\"dataNascita\":\"1990-01-01\",\"codiceFiscale\":\"RSSMRA90A01H501A\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id_medico", is(medico.getId_medico().intValue())))
                .andExpect(jsonPath("$.nome", is(medico.getNome())))
                .andExpect(jsonPath("$.cognome", is(medico.getCognome())))
                .andExpect(jsonPath("$.data_n", is(medico.getData_n().toString())))
                .andExpect(jsonPath("$.cf", is(medico.getCf())))
                .andExpect(jsonPath("$.stipendio", is(medico.getStipendio().doubleValue())))
                .andExpect(jsonPath("$.specializ", is(medico.getSpecializ())));
    }

    @Test
    public void testUpdateMedico() throws Exception {
        MedicoDto medico = new MedicoDto(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A", 1000.0f, "Medico di base");
        when(medicoService.updateMedico(any(Long.class), any(MedicoDto.class))).thenReturn(medico);

        mockMvc.perform(put("/api/medici/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id_medico\":1,\"nome\":\"Mario\",\"cognome\":\"Rossi\",\"data_n\":\"1990-01-01\",\"cf\":\"RSSMRA90A01H501A\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_medico", is(medico.getId_medico().intValue())))
                .andExpect(jsonPath("$.nome", is(medico.getNome())))
                .andExpect(jsonPath("$.cognome", is(medico.getCognome())))
                .andExpect(jsonPath("$.data_n", is(new SimpleDateFormat("yyyy-MM-dd").format(medico.getData_n())))) // Ensure the date format matches
                .andExpect(jsonPath("$.cf", is(medico.getCf())))
                .andExpect(jsonPath("$.stipendio", is(medico.getStipendio().doubleValue())))
                .andExpect(jsonPath("$.specializ", is(medico.getSpecializ())));
    }

    @Test
    public void testDeleteMedico() throws Exception {
        doNothing().when(medicoService).deleteMedico(1L);

        mockMvc.perform(delete("/api/medici/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}