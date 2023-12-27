package idsa.progetto_idsa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.service.AppuntamentoService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class AppuntamentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppuntamentoService appuntamentoService;

    @Test
    public void testCreateAppuntamentoDto() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        when(appuntamentoService.createAppuntamento(appuntamentoDto)).thenReturn(appuntamentoDto);

        mockMvc.perform(post("/api/appuntamenti")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id_appuntamento\":1,\"data\":\"2022-12-12\",\"ora\":\"10:00\",\"id_paziente\":1,\"id_medico\":1}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAllAppuntamenti() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        List<AppuntamentoDto> appuntamenti = Collections.singletonList(appuntamentoDto);
        when(appuntamentoService.getAllAppuntamenti()).thenReturn(appuntamenti);

        mockMvc.perform(get("/api/appuntamenti")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id_appuntamento", is(appuntamentoDto.getId_appuntamento().intValue())))
                .andExpect(jsonPath("$[0].data", is(appuntamentoDto.getData().toString())))
                .andExpect(jsonPath("$[0].paziente.id_paziente", is(appuntamentoDto.getPaziente().getId_paziente().intValue())))
                .andExpect(jsonPath("$[0].medico.id_medico", is(appuntamentoDto.getMedico().getId_medico().intValue())));
    }

    @Test
    public void testGetAppuntamentoById() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        when(appuntamentoService.getAppuntamentoById(1L)).thenReturn(appuntamentoDto);

        mockMvc.perform(get("/api/appuntamenti/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_appuntamento", is(appuntamentoDto.getId_appuntamento().intValue())))
                .andExpect(jsonPath("$.data", is(appuntamentoDto.getData().toString())))
                .andExpect(jsonPath("$.paziente.id_paziente", is(appuntamentoDto.getPaziente().getId_paziente().intValue())))
                .andExpect(jsonPath("$.medico.id_medico", is(appuntamentoDto.getMedico().getId_medico().intValue())));
    }

    @Test
    public void testUpdateAppuntamento() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "RSSMRA90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "RSSMRA90A01H501A", 1000.0f, "Chirurgo");
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        when(appuntamentoService.updateAppuntamento(any(Long.class), any(AppuntamentoDto.class))).thenReturn(appuntamentoDto);

        mockMvc.perform(put("/api/appuntamenti/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id_appuntamento\":1,\"data\":\"2022-12-12\",\"ora\":\"10:00\",\"id_paziente\":1,\"id_medico\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_appuntamento", is(appuntamentoDto.getId_appuntamento().intValue())))
                .andExpect(jsonPath("$.data", is(appuntamentoDto.getData().toString())))
                .andExpect(jsonPath("$.paziente.id_paziente", is(appuntamentoDto.getPaziente().getId_paziente().intValue())))
                .andExpect(jsonPath("$.medico.id_medico", is(appuntamentoDto.getMedico().getId_medico().intValue())));
    }

    @Test
    public void testDeleteAppuntamento() throws Exception {
        doNothing().when(appuntamentoService).deleteAppuntamento(1L);

        mockMvc.perform(delete("/api/appuntamenti/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
