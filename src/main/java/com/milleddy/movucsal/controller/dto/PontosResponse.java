package com.milleddy.movucsal.controller.dto;

import com.milleddy.movucsal.entity.Ponto;

import java.util.List;

public class PontosResponse {
    private final List<Ponto> pontos;

    public PontosResponse(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    public List<Ponto> getPontos() {
        return pontos;
    }
}
