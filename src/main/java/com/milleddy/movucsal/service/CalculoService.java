package com.milleddy.movucsal.service;

import br.com.mariojp.ai.agent.Functions;
import br.com.mariojp.ai.agent.INode;
import com.milleddy.movucsal.entity.Estado;
import org.springframework.stereotype.Service;

@Service
public class CalculoService extends Functions {

    double distanciaDireta;
    double distanciaReal;
    CaminhoService caminhoService;

    public CalculoService(CaminhoService caminhoService) {
        this.caminhoService = caminhoService;
        distanciaDireta = 0;
        distanciaReal = 0;
    }

    @Override
    public double g(INode no) {
        var estado = (Estado) no.getState();
        var objetivo = (Estado) getObjectives().get(0);

        distanciaReal += caminhoService.getDistanciaReal(estado.getPonto(), objetivo.getPonto());

        if (estado.getPonto().getAltura() != objetivo.getPonto().getAltura())
            distanciaReal *= 1.2;
        return distanciaReal;
    }

    @Override
    public double h(INode no) {
        var estado = (Estado) no.getState();
        var objetivo = (Estado) getObjectives().get(0);

        distanciaDireta += caminhoService.getDistanciaDireta(estado.getPonto(), objetivo.getPonto());

        return distanciaDireta;
    }

}
