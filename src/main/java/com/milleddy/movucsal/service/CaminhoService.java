package com.milleddy.movucsal.service;

import com.milleddy.movucsal.entity.Caminho;
import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.repository.CaminhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaminhoService {
    private final double EARTH_RADIUS = 6372.8;
    CaminhoRepository caminhoRepository;

    @Autowired
    public CaminhoService(CaminhoRepository caminhoRepository) {
        this.caminhoRepository = caminhoRepository;
    }

    public List<Caminho> getCaminhos() {
        return caminhoRepository.findAll();
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

    public double getDistanciaDireta(Ponto pontoInicial, Ponto pontoFinal) {
        double latitudeInicial = getLatitude(pontoInicial);
        double latitudeFinal = getLatitude(pontoFinal);
        double longitudeInicial = getLongitude(pontoInicial);
        double longitudeFinal = getLongitude(pontoFinal);

        double latitudeRadian = toRadians(latitudeFinal - latitudeInicial);
        double longitudeRadian = toRadians(longitudeFinal - longitudeInicial);

        latitudeInicial = toRadians(latitudeInicial);
        latitudeFinal = toRadians(latitudeFinal);

        double formula = Math.pow(Math.sin(latitudeRadian / 2), 2)
                + Math.pow(Math.sin(longitudeRadian / 2), 2) * Math.cos(latitudeInicial) * Math.cos(latitudeFinal);

        double calc = 2 * Math.asin(Math.sqrt(formula));
        double distance = EARTH_RADIUS * calc;

        return distance * 1000;
    }


    private double toRadians(double value) {
        return Math.toRadians(value);
    }

    private double getLatitude(Ponto ponto) {
        return Double.parseDouble(ponto.getLatitude());
    }

    private double getLongitude(Ponto ponto) {
        return Double.parseDouble(ponto.getLongitude());
    }

}
