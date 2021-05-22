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

    public List<IState> execute(IState arg0) throws ImpossibleActionException {
        List<IState> iEstados = new ArrayList<>();
        Estado estado = (Estado) arg0;
        Ponto ponto = estado.getPonto();

        List<Ponto> pontosAdjacentes = caminhoService.getPontosAdjacentes(ponto.getId());


        if (pontosAdjacentes.size() == 0){
            throw new ImpossibleActionException();
        }

        for (Ponto p : pontosAdjacentes) {
            Estado novoEstado = (Estado) estado.clone();
            novoEstado.setPonto(p);
            iEstados.add(novoEstado);
        }

        return iEstados;
    }

}
