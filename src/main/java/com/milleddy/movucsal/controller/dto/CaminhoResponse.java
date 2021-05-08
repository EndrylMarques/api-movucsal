package com.milleddy.movucsal.controller.dto;

import br.com.mariojp.ai.agent.INode;
import com.milleddy.movucsal.entity.Ponto;

public class CaminhoResponse {

    // state:
    int id;
    String codigo;
    String descricao;
    String predio;
    boolean acessivel;
    String latitude;
    String longitude;
    String altura;
    String tipoPonto;

    //parent
    //action
    String action;
    //depth
    double depth;
    //cost
    double cost;
    //utility
    double utility;
    //heuristic
    double heuristic;
    //next

    //gets e sets
    //INode to CaminhoResponse


    public CaminhoResponse(INode iNode) {
        //iNode.getState();
    }
}
