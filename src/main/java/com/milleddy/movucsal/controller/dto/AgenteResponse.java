package com.milleddy.movucsal.controller.dto;

import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.IState;
import com.milleddy.movucsal.entity.Ponto;

import java.util.ArrayList;
import java.util.List;

public class AgenteResponse {

    int profundidade;
    double custo;
    double heuristica;
    List<INode> pontosVisitados;
    List<IState> pontosVisitados1 = new ArrayList<>();

    public AgenteResponse(List<INode> nodes, INode finalNode) {
        this.profundidade = finalNode.getDepth();
        this.custo = finalNode.getCost();
        this.heuristica = finalNode.getHeuristic();
        for (INode node : nodes) {
            this.pontosVisitados1.add(node.getState());
        }

        this.pontosVisitados = nodes;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public double getCusto() {
        return custo;
    }

    public double getHeuristica() {
        return heuristica;
    }

    public List<INode> getPontosVisitados() {
        return pontosVisitados;
    }

    public List<IState> getPontosVisitados1() {
        return pontosVisitados1;
    }

}
