package com.milleddy.movucsal.entity;

public enum TipoPonto {

    SALA(1),
    BANHEIRO_FEMININO(2),
    BANHEIRO_MASCULINO(3),
    ESCADA(4),
    RAMPA(5),
    BEBEDOURO(6),
    CORREDOR(7),
    LAMI(8);

    private int valor;

    TipoPonto(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
