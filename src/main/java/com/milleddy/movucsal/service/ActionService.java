package com.milleddy.movucsal.service;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.action.AbstractAction;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;
import com.milleddy.movucsal.entity.Estado;
import com.milleddy.movucsal.entity.Ponto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActionService extends AbstractAction {
    private CaminhoService caminhoService;

    public ActionService(CaminhoService caminhoService) {
        this.caminhoService = caminhoService;
    }

    @Override
    public List<IState> execute(IState arg0) throws ImpossibleActionException {
        List<IState> iEstados = new ArrayList<>();
        var estado = (Estado) arg0;
        var ponto = estado.getPonto();

        var pontosAdjacentes = caminhoService.getPontosAdjacentes(ponto.getId());


        if (pontosAdjacentes.isEmpty()){
            throw new ImpossibleActionException();
        }

        for (Ponto p : pontosAdjacentes) {
            var novoEstado = (Estado) estado.clone();
            novoEstado.setPonto(p);
            iEstados.add(novoEstado);
        }

        return iEstados;
    }

}
