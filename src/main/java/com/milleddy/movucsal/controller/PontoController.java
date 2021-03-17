package com.milleddy.movucsal.controller;


import com.milleddy.movucsal.controller.dto.PontosResponse;
import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.service.PontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pontos")
public class PontoController {

    PontoService pontoService;

    @Autowired
    public PontoController(PontoService pontoService) {
        this.pontoService = pontoService;
    }

    @GetMapping
    public ResponseEntity<PontosResponse> getPontos(){
        List<Ponto> pontos = pontoService.getAll();
        PontosResponse response = new PontosResponse(pontos);

        return ResponseEntity.ok(response);
    }
}
