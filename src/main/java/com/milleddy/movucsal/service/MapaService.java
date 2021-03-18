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

    public List<Ponto> getPontosAdjacentes(int pontoId) {
        List<Ponto> pontosAdjacentes = new ArrayList<>();
        for (Caminho caminho : getCaminhos()) {
            if (caminho.getPontoOrigem().getId() == pontoId)
                pontosAdjacentes.add(caminho.getPontoDestino());
        }
        return pontosAdjacentes;
    }

    public double getDistanciaReal(Ponto pontoInicial, Ponto pontoFinal) {
        for (Caminho caminho : getCaminhos()) {
            var pontoOrigem = caminho.getPontoOrigem();
            var pontoDestino = caminho.getPontoDestino();

            if (pontoOrigem.getId() == pontoInicial.getId() || pontoDestino.getId() == pontoFinal.getId())
                return caminho.getDistancia();
            if (pontoOrigem.getId() == pontoFinal.getId() || pontoDestino.getId() == pontoInicial.getId())
                return caminho.getDistancia();
        }
        return 0d;
    }

    public List<Caminho> getCaminhos() {
        return caminhoRepository.findAll();
    }
}
