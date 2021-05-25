package com.milleddy.movucsal.service;

import br.com.mariojp.ai.agent.AgentFactory;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.IAgent;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;
import com.milleddy.movucsal.controller.dto.AgenteResponse;
import com.milleddy.movucsal.entity.Estado;
import javassist.NotFoundException;
import org.apache.commons.collections.map.SingletonMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AgentService {

    private int TIPO_ALGORITMO = IAgent.START_SEARCH;
    private String ACAO = "Ir de um ponto a outro";

    private CaminhoService caminhoService;
    private PontoService pontoService;

    public AgentService(CaminhoService caminhoService, PontoService pontoService) {
        this.caminhoService = caminhoService;
        this.pontoService = pontoService;
    }

    public AgenteResponse gerarCaminhoPorAgente(int initialSpotId, int finalSpotId, boolean acessivel) throws NotFoundException {
        AgentModel agentModel = new AgentModel();

        if (acessivel)
            agentModel.addAction(ACAO, new ActionServiceAcessivel(caminhoService));
        else
            agentModel.addAction(ACAO, new ActionService(caminhoService));

        Estado initialState = getEstadoByPontoId(initialSpotId);
        agentModel.setInitState(initialState);

        Estado finalState = getEstadoByPontoId(finalSpotId);
        agentModel.addObjective(finalState);

        agentModel.setFunctions(new CalculoService(caminhoService));
        agentModel.setType(TIPO_ALGORITMO);

        IAgent iAgent = AgentFactory.createAgent(agentModel);

        INode finalNode = null;
        try {
            finalNode = iAgent.function();
        } catch (EmptyBorderException e) {
            e.printStackTrace();
        }

        List<INode> nodes = iAgent.getPath(finalNode);
        System.out.println(nodes); //path (list of nodes that were visited)
        System.out.println(iAgent); //path summary (time, nodes visited/expanded)
        System.out.println(finalNode); //final node summary (cost, ??, last visited node)

        return new AgenteResponse(nodes, finalNode);
    }

    private Estado getEstadoByPontoId(int pontoId) throws NotFoundException {
        var ponto = pontoService.getById(pontoId);
        if (ponto == null)
            throw new NotFoundException("Ponto não encontrado");

        Estado estado = new Estado();

        estado.setPonto(ponto);
        return estado;
    }
}
