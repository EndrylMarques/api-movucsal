package com.milleddy.movucsal.service;

import br.com.mariojp.ai.agent.AgentFactory;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;
import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.entity.TipoPonto;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AgentServiceTest {
    private AgentService agentService;

    @Mock
    private PontoService pontoService;
    @Mock
    private CaminhoService caminhoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        agentService = new AgentService(caminhoService, pontoService);
    }

    @Test
    @Disabled
    void generatePathWithAgentDeveRetornarCaminhoEntreDoisPontos() throws NotFoundException, EmptyBorderException {
        var pontoInicial = new Ponto(1, "PIT", "Ponto Inicial Teste", 'A',
                true, "11.324", "12.322", 1, TipoPonto.BANHEIRO_FEMININO);

        var pontoFinal = new Ponto(4, "PFT", "Ponto Final Teste", 'A',
                true, "11.456", "12.212", 1, TipoPonto.BANHEIRO_FEMININO);

        var acessivel = false;
        when(pontoService.getById(1)).thenReturn(pontoInicial);
        when(pontoService.getById(4)).thenReturn(pontoFinal);

        //when
        var result = agentService.gerarCaminhoPorAgente(pontoInicial.getId(), pontoFinal.getId(), true);

        verify(AgentFactory.createAgent(any()));
        verify(AgentFactory.createAgent(any()).function());

    }

}