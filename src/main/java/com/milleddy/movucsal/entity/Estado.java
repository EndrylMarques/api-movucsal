package com.milleddy.movucsal.entity;

import br.com.mariojp.ai.agent.AbstractState;

public class Estado extends AbstractState {

    private Ponto ponto;

    public Object clone() {
        Estado copia = new Estado();
        copia.setPonto(this.ponto);

        return copia;
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    @Override
    public boolean equals(Object estado) {
        if(estado.getClass() != Estado.class){
            return false;
        }

        Estado outro = (Estado) estado;
        return this.getPonto().getId() == outro.getPonto().getId();
    }

    @Override
    public String toString() {
        return "Estado = {" +
                "ponto: " + ponto.getDescricao() +
                '}';
    }
}
