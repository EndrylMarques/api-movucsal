package com.milleddy.movucsal.service;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;
import com.milleddy.movucsal.entity.Estado;

import java.util.ArrayList;
import java.util.List;

public class ActionServiceAcessivel extends ActionService {

    public ActionServiceAcessivel(CaminhoService caminhoService) {
        super(caminhoService);
    }

    public List<IState> execute(IState arg0) throws ImpossibleActionException {
        List<IState> iEstados = super.execute(arg0);
        List<IState> iEstadosAcessiveis = new ArrayList<>();

        for (var iEstado : iEstados) {
            var estado = (Estado) iEstado;
            if (estado.getPonto().isAcessivel())
                iEstadosAcessiveis.add(iEstado);
        }

        if (iEstadosAcessiveis.size() > 0)
            return iEstadosAcessiveis;

        throw new ImpossibleActionException();
    }

}
