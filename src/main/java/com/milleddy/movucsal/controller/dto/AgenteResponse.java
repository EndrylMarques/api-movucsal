package com.milleddy.movucsal.controller.dto;

import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.IState;

import java.util.ArrayList;
import java.util.List;

public class AgenteResponse {

    private List<IState> pontosVisitados = new ArrayList<>();

    public AgenteResponse(List<INode> nodes) {
        for (INode node : nodes) {
            this.pontosVisitados.add(node.getState());
        }
    }

    public List<IState> getPontosVisitados() {
        return pontosVisitados;
    }

}
