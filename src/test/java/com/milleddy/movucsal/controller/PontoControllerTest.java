package com.milleddy.movucsal.controller;

import com.milleddy.movucsal.entity.Ponto;
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

@WebMvcTest(PontoController.class)
public class PontoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PontoService pontoService;

    @Test
    void shouldReturn200WhenGetAllPoints() throws Exception {
        List<Ponto> pontos = List.of(
                new Ponto(),
                new Ponto()
        );

        when(pontoService.getAll()).thenReturn(pontos);

        mockMvc.perform(get("/pontos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pontos", hasSize(2)));
    }

}
