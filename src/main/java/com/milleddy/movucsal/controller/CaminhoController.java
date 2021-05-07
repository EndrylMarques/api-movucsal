package com.milleddy.movucsal.controller;


import br.com.mariojp.ai.agent.INode;
import com.milleddy.movucsal.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caminho")
public class CaminhoController {

    private AgentService caminhoService;

    @Autowired
    public CaminhoController(AgentService caminhoService) {
        this.caminhoService = caminhoService;
    }

    @GetMapping
    public ResponseEntity<List<INode>> getCaminhoFromPontos(@RequestParam("pontoInicialId") int pontoInicialId, @RequestParam("pontoInicialId") int pontoFinalId) {

        var caminho = caminhoService.generatePathWithAgent(pontoInicialId, pontoFinalId);

        var response = caminho;

        return ResponseEntity.ok(caminho);
    }
}
