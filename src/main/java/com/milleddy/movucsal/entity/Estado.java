package com.milleddy.movucsal.entity;

import br.com.mariojp.ai.agent.AbstractState;

import java.util.Objects;

public class Estado extends AbstractState {

    private Ponto ponto;

    @Override
    public Object clone() {
        var copia = new Estado();
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
        if (estado == null || estado.getClass() != Estado.class) return false;

        var outro = (Estado) estado;
        return this.getPonto().getId() == outro.getPonto().getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(ponto);
    }

    @Override
    public String toString() {
        return "Estado = {" +
                "ponto: " + ponto.getDescricao() +
                '}';
    }
}
