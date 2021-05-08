package com.milleddy.movucsal.controller;


import br.com.mariojp.ai.agent.INode;
import com.milleddy.movucsal.service.AgentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agente")
public class AgenteController {

    private AgentService agentService;

    @Autowired
    public AgenteController(AgentService caminhoService) {
        this.agentService = caminhoService;
    }

    @GetMapping()
    public ResponseEntity<List<INode>> getCaminhoFinal(@RequestParam("pontoInicialId") int pontoInicialId,
                                                       @RequestParam("pontoFinalId") int pontoFinalId) throws NotFoundException {

        List<INode> caminho = null;
        caminho = agentService.generatePathWithAgent(pontoInicialId, pontoFinalId);

        if (caminho == null)
            return ResponseEntity.badRequest().build();

       // var response = caminho;

        return ResponseEntity.ok(caminho);
    }
}
