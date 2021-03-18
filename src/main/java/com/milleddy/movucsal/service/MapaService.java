package com.milleddy.movucsal.service;

import com.milleddy.movucsal.entity.Caminho;
import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.repository.CaminhoRepository;
import com.milleddy.movucsal.repository.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapaService {

    CaminhoRepository caminhoRepository;

    @Autowired
    public MapaService(CaminhoRepository caminhoRepository) {
        this.caminhoRepository = caminhoRepository;
    }

    public List<Ponto> pontosAdjacentes(int pontoId) {
        List<Ponto> pontosAdjacentes = new ArrayList<>();
        for (Caminho caminho : getCaminhos()) {
            if (caminho.getPontoOrigem().getId() == pontoId)
                pontosAdjacentes.add(caminho.getPontoDestino());
        }
        return pontosAdjacentes;
    }

    public List<Caminho> getCaminhos() {
       return caminhoRepository.findAll();
    }
}
