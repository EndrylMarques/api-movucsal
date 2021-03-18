package com.milleddy.movucsal.service;

import br.com.mariojp.ai.agent.Functions;
import br.com.mariojp.ai.agent.INode;
import com.milleddy.movucsal.entity.Estado;
import com.milleddy.movucsal.repository.CaminhoRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculoService extends Functions {

    double distanciaDireta;
    double distanciaReal;
    CaminhoRepository caminhoRepository;

    public CalculoService(CaminhoRepository caminhoRepository) {
        this.caminhoRepository = caminhoRepository;
        distanciaDireta = 0;
        distanciaReal = 0;
    }

    @Override
    public double g(INode no) {
        double distancia = 0;
        Estado estado = (Estado) no.getState();
        Estado objetivo = (Estado) getObjectives().get(0);
        MapaService mapaService = new MapaService(caminhoRepository);

        distanciaReal += mapaService.getDistanciaReal(estado.getPonto(), objetivo.getPonto());

        if (estado.getPonto().getAltura() != objetivo.getPonto().getAltura())
            distanciaReal *= 1.2;
        return distanciaReal;
    }

    @Override
    public double h(INode no) {
        Estado estado = (Estado) no.getState();
        Estado objetivo = (Estado) getObjectives().get(0);
        MapaService mapa = new MapaService(caminhoRepository);

        distanciaDireta += mapa.getDistanciaDireta(estado.getPonto(), objetivo.getPonto());

        return distanciaDireta;
    }

}
