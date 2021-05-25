package com.milleddy.movucsal.controller;


import com.milleddy.movucsal.controller.dto.AgenteResponse;
import com.milleddy.movucsal.service.AgentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agente")
public class AgenteController {

    private AgentService agentService;

    @Autowired
    public AgenteController(AgentService caminhoService) {
        this.agentService = caminhoService;
    }

    @GetMapping()
    public ResponseEntity<AgenteResponse> getCaminhoFinal(@RequestParam int pontoInicialId,
                                                          @RequestParam int pontoFinalId, @RequestParam boolean acessivel) throws NotFoundException {
        var caminho = agentService.gerarCaminhoPorAgente(pontoInicialId, pontoFinalId, acessivel);

        if (caminho == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(caminho);
    }
}
