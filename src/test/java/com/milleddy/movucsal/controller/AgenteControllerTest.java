package com.milleddy.movucsal.controller;

import br.com.mariojp.ai.agent.INode;
import com.milleddy.movucsal.service.AgentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

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
        boolean caminhoAcessivel = false;

        List<INode> nodes = new ArrayList<>();

        when(agentService.gerarCaminhoPorAgente(pontoInicialId, pontoFinalId, caminhoAcessivel))
                .thenReturn(nodes);

        mockMvc.perform(get("/agente/")
                .param("pontoInicialId", "1")
                .param("pontoFinalId", "3")
                .param("acessivel", "false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.teste").exists());
    }
}