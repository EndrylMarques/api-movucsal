package com.milleddy.movucsal.service;

import br.com.mariojp.ai.agent.AgentFactory;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.IAgent;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;
import com.milleddy.movucsal.entity.Estado;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    private int ALGORITHM_TYPE = IAgent.BREADTH_FIRST_SEARCH;
    private String ACTION_NAME = "Ir de um ponto a outro";

    private CaminhoService caminhoService;
    private PontoService pontoService;

    public AgentService(CaminhoService caminhoService, PontoService pontoService) {
        this.caminhoService = caminhoService;
        this.pontoService = pontoService;
    }

    public List<INode> generatePathWithAgent(int initialSpotId, int finalSpotId) throws NotFoundException { //todo: test?
        AgentModel agentModel = new AgentModel();
        agentModel.addAction(ACTION_NAME, new ActionService(caminhoService));

        Estado initialState = getStateBySpotId(initialSpotId);
        agentModel.setInitState(initialState);

        Estado finalState = getStateBySpotId(finalSpotId);
        agentModel.addObjective(finalState);

        agentModel.setFunctions(new CalculoService(caminhoService));
        agentModel.setType(ALGORITHM_TYPE);

        IAgent iAgent = AgentFactory.createAgent(agentModel);

        INode finalNode = null;
        try {
            finalNode = iAgent.function();
        } catch (EmptyBorderException e) {
            e.printStackTrace();
        }

        List nodes = iAgent.getPath(finalNode);
        System.out.println(nodes); //path (list of nodes that builds the path)
        System.out.println(iAgent); //path summary (time, nodes visited/expanded)
        System.out.println(finalNode); //last node summary (cost, ??, last visited node)

        return nodes;
    }

    private Estado getStateBySpotId(int spotId) throws NotFoundException {
        var spot = pontoService.getById(spotId);
        if (spot == null)
            throw new NotFoundException("Ponto não encontrado");

        Estado state = new Estado();

        state.setPonto(spot);
        return state;
    }

}
