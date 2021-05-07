package com.milleddy.movucsal.controller;

import com.milleddy.movucsal.controller.dto.PontoResponse;
import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.service.PontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pontos")
public class PontoController {

    PontoService pontoService;

    @Autowired
    public PontoController(PontoService pontoService) {
        this.pontoService = pontoService;
    }

    @GetMapping
    public ResponseEntity<List<PontoResponse>> getPontos() {
        List<Ponto> pontos = pontoService.getAll();

        var response = pontos.stream()
                .map(p -> new PontoResponse(p)).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontoResponse> getPontoById(@PathVariable int id) {
        Ponto ponto = pontoService.getById(id);
        if (ponto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new PontoResponse(ponto));
    }
}
