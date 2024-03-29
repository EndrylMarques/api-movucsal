package com.milleddy.movucsal.controller;

import com.milleddy.movucsal.controller.dto.PontoResponse;
import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.entity.TipoPonto;
import com.milleddy.movucsal.exceptions.MovUcsalException;
import com.milleddy.movucsal.service.PontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
                .map(p -> new PontoResponse(p))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontoResponse> getPontoById(@PathVariable int id) {
        var ponto = pontoService.getById(id);
        if (ponto == null) {
            throw new MovUcsalException("Ponto não encontrado", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(new PontoResponse(ponto));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<PontoResponse>> getPontoByTipoPonto(@PathVariable TipoPonto tipo) {
        List<Ponto> pontos = pontoService.getByTipoPonto(tipo);
        if (pontos.isEmpty()) {
            throw new MovUcsalException(String.format("Pontos do tipo %s não encontrados", tipo), HttpStatus.NOT_FOUND);
        }

        return ResponseEntity
                .ok(pontos.stream()
                        .map(p -> new PontoResponse(p))
                        .collect(Collectors.toList()));
    }
}
