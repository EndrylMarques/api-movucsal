package com.milleddy.movucsal.controller;

import com.milleddy.movucsal.controller.dto.AgenteResponse;
import com.milleddy.movucsal.exceptions.MovUcsalException;
import com.milleddy.movucsal.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
                                                          @RequestParam int pontoFinalId, @RequestParam boolean acessivel) {
        try {
            var caminho = agentService.gerarCaminhoPorAgente(pontoInicialId, pontoFinalId, acessivel);

            if (caminho == null)
                throw new MovUcsalException("Caminho não encontrado", HttpStatus.NOT_FOUND);

            return ResponseEntity.ok(caminho);
        } catch (MovUcsalException ex) {
            throw new MovUcsalException(ex.getMessage(), ex.getStatus());
        }
    }
}
