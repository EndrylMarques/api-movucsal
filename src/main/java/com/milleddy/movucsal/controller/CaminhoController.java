package com.milleddy.movucsal.controller;


import com.milleddy.movucsal.entity.Caminho;
import com.milleddy.movucsal.service.CaminhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/caminho")
public class CaminhoController {
    CaminhoService caminhoService;

    @Autowired
    public CaminhoController(CaminhoService caminhoService) {
        this.caminhoService = caminhoService;
    }

    @GetMapping
    public ResponseEntity<List<Caminho>> getCaminhos() {
        return ResponseEntity.ok(caminhoService.getCaminhos());
    }
}
