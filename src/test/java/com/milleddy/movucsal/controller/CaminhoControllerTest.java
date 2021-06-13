package com.milleddy.movucsal.controller;

import com.milleddy.movucsal.entity.Caminho;
import com.milleddy.movucsal.service.CaminhoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CaminhoController.class)
class CaminhoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CaminhoService caminhoService;

    @Test
    void shouldReturn200WhenGetAllPaths() throws Exception {
        List<Caminho> caminhos = List.of(
                new Caminho(),
                new Caminho()
        );

        when(caminhoService.getCaminhos()).thenReturn(caminhos);

        mockMvc.perform(get("/caminho"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)));
    }

}