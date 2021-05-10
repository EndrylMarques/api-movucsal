package com.milleddy.movucsal.controller;

import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.entity.TipoPonto;
import com.milleddy.movucsal.service.PontoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@WebMvcTest(PontoController.class)
public class PontoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PontoService pontoService;

    @Test
    void shouldReturn200WhenGetAllSpots() throws Exception {
        List<Ponto> pontos = List.of(
                new Ponto(),
                new Ponto()
        );

        when(pontoService.getAll()).thenReturn(pontos);

        mockMvc.perform(get("/pontos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void shouldReturn200WhenGetExistingPointById() throws Exception {
        Ponto ponto = new Ponto(2, "LA2", "Lami 2", 'B', true,
                "-12.948070", "-38.412985", 4, TipoPonto.LAMI);

        when(pontoService.getById(2)).thenReturn(ponto);

        mockMvc.perform(get("/pontos/" + ponto.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)));
    }
}
