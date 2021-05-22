package com.milleddy.movucsal.controller.dto;

import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.IState;

import java.util.ArrayList;
import java.util.List;

public class AgenteResponse {

    private String acao;
    private int profundidade;
    private double custo;
    private double utility;
    private double heuristica;
    private IState ultimoEstado;
    private INode caminho;
    private List<String> resultado = new ArrayList<>();

    String pontosVisitados;

    public AgenteResponse(List<INode> nodes) {
        for (INode node : nodes) {
            this.resultado.add("Nó " + nodes.indexOf(node)
                    + ". " + node.getAction()
                    + " - Custo: " + node.getCost()
                    + " - Heuristica: " + node.getHeuristic()
                    + " - Profundidade: " + node.getDepth()
                    + " - " + node.getState()
            );
        }
//        this.acao = nodes.getAction();
//        this.profundidade = finalPath.getDepth();
//        this.custo = finalPath.getCost();
//        this.utility = finalPath.getUtility();
//        this.heuristica = finalPath.getHeuristic();
//        this.ultimoEstado = finalPath.getState();
//        this.caminho = finalPath.getParent();
//        this.pontosVisitados = finalPath.getParent().toString();
    }

    public List<String> getTeste() {
        return resultado;
    }

    public String getAcao() {
        return acao;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public double getCusto() {
        return custo;
    }

    public double getUtility() {
        return utility;
    }

    public double getHeuristica() {
        return heuristica;
    }

    public IState getUltimoEstado() {
        return ultimoEstado;
    }

    public INode getCaminho() {
        return caminho;
    }

    public String getPontosVisitados() {
        return pontosVisitados;
    }
}
