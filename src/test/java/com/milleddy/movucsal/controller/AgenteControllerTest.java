package com.milleddy.movucsal.controller;

import com.milleddy.movucsal.controller.dto.AgenteResponse;
import com.milleddy.movucsal.service.AgentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AgenteController.class)
class AgenteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AgentService agentService;

    @Test
    void getCaminhoFinalShouldReturnCaminhoCompleto() throws Exception {
        int pontoInicialId = 1;
        int pontoFinalId = 4;

        var nodes = new AgenteResponse(Collections.emptyList());

        when(agentService.gerarCaminhoPorAgente(pontoInicialId, pontoFinalId, false))
                .thenReturn(nodes);

        mockMvc.perform(get("/agente/")
                .param("pontoInicialId", String.valueOf(pontoInicialId))
                .param("pontoFinalId", String.valueOf(pontoFinalId))
                .param("acessivel", "false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.pontosVisitados").exists())
                .andExpect(jsonPath("$.pontosVisitados").isArray());
    }

    @Test
    void getCaminhoFinalShouldThrowExceptionWhenCaminhoIsNotFound() throws Exception {
        int pontoInicialId = 1;
        int pontoFinalId = 4;

        when(agentService.gerarCaminhoPorAgente(pontoInicialId, pontoFinalId, false))
                .thenReturn(null);

        mockMvc.perform(get("/agente/")
                .param("pontoInicialId", String.valueOf(pontoInicialId))
                .param("pontoFinalId", String.valueOf(pontoFinalId))
                .param("acessivel", "false"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.pontosVisitados").doesNotExist());
    }

}