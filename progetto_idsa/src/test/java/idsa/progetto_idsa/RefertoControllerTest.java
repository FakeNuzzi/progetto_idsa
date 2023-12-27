package idsa.progetto_idsa;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import idsa.progetto_idsa.dto.RefertoDto;
import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Cartella;
import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.entity.Referto;
import idsa.progetto_idsa.entityID.RefertoID;
import idsa.progetto_idsa.service.RefertoService;

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
class RefertoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RefertoService refertoService;

    @Test
    public void testGetAllAppuntamenti() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        List<Referto> referticartella = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referticartella);
        RefertoDto referto = new RefertoDto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        List<RefertoDto> referti = Collections.singletonList(referto);
        when(refertoService.getAllReferti()).thenReturn(referti);

        mockMvc.perform(get("/api/referti")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id_referto", is(referto.getId_referto().intValue())))
                .andExpect(jsonPath("$[0].appuntamento.id_appuntamento", is(referto.getAppuntamento().getId_appuntamento().intValue())))
                .andExpect(jsonPath("$[0].tipo_vis", is(referto.getTipo_vis())))
                .andExpect(jsonPath("$[0].prescr", is(referto.getPrescr())))
                .andExpect(jsonPath("$[0].cartella.id_cartella", is(referto.getCartella().getId_cartella().intValue())));
    }

    @Test
    @Disabled
    public void testGetRefertoById() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        List<Referto> referticartella = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referticartella);
        RefertoDto referto = new RefertoDto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        RefertoID refertoID = new RefertoID(1L, appuntamento);
        when(refertoService.getRefertoById(refertoID)).thenReturn(referto);

        mockMvc.perform(get("/api/referti/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_referto", is(referto.getId_referto().intValue())))
                .andExpect(jsonPath("$.appuntamento.id_appuntamento", is(referto.getAppuntamento().getId_appuntamento().intValue())))
                .andExpect(jsonPath("$.tipo_vis", is(referto.getTipo_vis())))
                .andExpect(jsonPath("$.prescr", is(referto.getPrescr())))
                .andExpect(jsonPath("$.cartella.id_cartella", is(referto.getCartella().getId_cartella().intValue())));
    }

    @Test
    public void testCreateReferto() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        List<Referto> referticartella = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referticartella);
        RefertoDto referto = new RefertoDto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        when(refertoService.createReferto(any(RefertoDto.class))).thenReturn(referto);

        mockMvc.perform(post("/api/referti")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"Mario\",\"cognome\":\"Rossi\",\"dataNascita\":\"1990-01-01\",\"codiceFiscale\":\"RSSMRA90A01H501A\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id_referto", is(referto.getId_referto().intValue())))
                .andExpect(jsonPath("$.appuntamento.id_appuntamento", is(referto.getAppuntamento().getId_appuntamento().intValue())))
                .andExpect(jsonPath("$.tipo_vis", is(referto.getTipo_vis())))
                .andExpect(jsonPath("$.prescr", is(referto.getPrescr())))
                .andExpect(jsonPath("$.cartella.id_cartella", is(referto.getCartella().getId_cartella().intValue())));
    }

    @Test
    @Disabled
    public void testUpdateReferto() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        List<Referto> referticartella = new ArrayList<Referto>();
        Cartella cartella = new Cartella(1L, paziente, referticartella);
        RefertoDto referto = new RefertoDto(1L, appuntamento, "Visita", "Prescrizione", cartella);
        when(refertoService.updateReferto(any(RefertoID.class), any(RefertoDto.class))).thenReturn(referto);

        mockMvc.perform(put("/api/referti/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id_referto\":1,\"nome\":\"Mario\",\"cognome\":\"Rossi\",\"data_n\":\"1990-01-01\",\"cf\":\"RSSMRA90A01H501A\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_referto", is(referto.getId_referto().intValue())))
                .andExpect(jsonPath("$.appuntamento.id_appuntamento", is(referto.getAppuntamento().getId_appuntamento().intValue())))
                .andExpect(jsonPath("$.tipo_vis", is(referto.getTipo_vis())))
                .andExpect(jsonPath("$.prescr", is(referto.getPrescr())))
                .andExpect(jsonPath("$.cartella.id_cartella", is(referto.getCartella().getId_cartella().intValue())));
    }

    @Test
    @Disabled
    public void testDeleteReferto() throws Exception {
        Paziente paziente = new Paziente(1L, "Mario", "Rossi", Date.valueOf("1990-01-01"), "MRORSS90A01H501A");
        Medico medico = new Medico(1L, "Mario", "Rossi", Date.valueOf("1990-05-11"), "MRORSS90A01H501A", 1000.0f, "Chirurgo");
        Appuntamento appuntamento = new Appuntamento(1L, Date.valueOf("2022-12-01"), "Chirurgo", paziente, medico);
        RefertoID refertoID = new RefertoID(1L, appuntamento);
        doNothing().when(refertoService).deleteReferto(refertoID);

        mockMvc.perform(delete("/api/referti/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}