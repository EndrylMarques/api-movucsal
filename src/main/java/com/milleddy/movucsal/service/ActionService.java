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
        List<IState> stateList = new ArrayList<>();
        Estado state = (Estado) arg0;
        Ponto spot = state.getPonto();

        List<Ponto> adjacentSpots = caminhoService.getPontosAdjacentes(spot.getId());
        if (adjacentSpots.size() == 0){
            throw new ImpossibleActionException();
        }

        for (Ponto p : adjacentSpots) {
            Estado newState = (Estado) state.clone();
            newState.setPonto(p);
            stateList.add(newState);
        }

        return stateList;
    }

}
