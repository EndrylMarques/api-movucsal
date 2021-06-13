package com.milleddy.movucsal.service;

import br.com.mariojp.ai.agent.AgentFactory;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.IAgent;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;
import com.milleddy.movucsal.controller.dto.AgenteResponse;
import com.milleddy.movucsal.entity.Estado;
import com.milleddy.movucsal.exceptions.MovUcsalException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

    private static final int TIPO_ALGORITMO = IAgent.START_SEARCH;
    private static final String ACAO = "Ir de um ponto a outro";

    private CaminhoService caminhoService;
    private PontoService pontoService;

    public AgentService(CaminhoService caminhoService, PontoService pontoService) {
        this.caminhoService = caminhoService;
        this.pontoService = pontoService;
    }

    public AgenteResponse gerarCaminhoPorAgente(int initialSpotId, int finalSpotId, boolean acessivel) throws MovUcsalException {
        var agentModel = new AgentModel();

        if (acessivel)
            agentModel.addAction(ACAO, new ActionServiceAcessivel(caminhoService));
        else
            agentModel.addAction(ACAO, new ActionService(caminhoService));

        var initialState = getEstadoByPontoId(initialSpotId);
        agentModel.setInitState(initialState);

        var finalState = getEstadoByPontoId(finalSpotId);
        agentModel.addObjective(finalState);

        agentModel.setFunctions(new CalculoService(caminhoService));
        agentModel.setType(TIPO_ALGORITMO);

        var iAgent = AgentFactory.createAgent(agentModel);

        INode finalNode = null;
        try {
            finalNode = iAgent.function();
        } catch (EmptyBorderException e) {
            e.printStackTrace();
        }

        var nodes = iAgent.getPath(finalNode);
        System.out.println(nodes); //path (list of nodes that were visited)
        System.out.println(iAgent); //path summary (time, nodes visited/expanded)
        System.out.println(finalNode); //final node summary (cost, ??, last visited node)

        return new AgenteResponse(nodes);
    }

    private Estado getEstadoByPontoId(int pontoId) throws MovUcsalException {
        var ponto = pontoService.getById(pontoId);
        if (ponto == null)
            throw new MovUcsalException("Ponto não encontrado", HttpStatus.NOT_FOUND);

        var estado = new Estado();

        estado.setPonto(ponto);
        return estado;
    }
}
