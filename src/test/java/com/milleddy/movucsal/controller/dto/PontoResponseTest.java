package com.milleddy.movucsal.controller.dto;

import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.entity.TipoPonto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PontoResponseTest {

    @Test
    void pontoResponseShouldReturnPonto(){
        Ponto ponto = new Ponto(2, "LA2", "Lami 2", 'B', true,
                "-12.948070", "-38.412985", 4, TipoPonto.LAMI);
        PontoResponse response = new PontoResponse(ponto);

        assertEquals(ponto.getId(), response.getId());
        assertEquals(ponto.getCodigo(), response.getCodigo());
        assertEquals(ponto.getDescricao(), response.getDescricao());

        assertEquals(ponto.getPredio(), response.getPredio());
        assertEquals(ponto.isAcessivel(), response.isAcessivel());
        assertEquals(ponto.getLatitude(), response.getLatitude());

        assertEquals(ponto.getLongitude(), response.getLongitude());
        assertEquals(ponto.getAltura(), response.getAltura());
        assertEquals(ponto.getTipoPonto(), response.getTipoPonto());
    }

}