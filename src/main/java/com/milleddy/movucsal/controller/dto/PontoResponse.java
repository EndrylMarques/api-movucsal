package com.milleddy.movucsal.controller.dto;

import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.entity.TipoPonto;

public class PontoResponse {
    private int id;
    private String codigo;
    private String descricao;
    private char predio;
    private boolean acessivel;
    private String latitude;
    private String longitude;
    private int altura;
    private TipoPonto tipoPonto;

    public PontoResponse(Ponto ponto) {
        this.id = ponto.getId();
        this.codigo = ponto.getCodigo();
        this.descricao = ponto.getDescricao();
        this.predio = ponto.getPredio();
        this.acessivel = ponto.isAcessivel();
        this.latitude = ponto.getLatitude();
        this.longitude = ponto.getLongitude();
        this.altura = ponto.getAltura();
        this.tipoPonto = ponto.getTipoPonto();
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public char getPredio() {
        return predio;
    }

    public boolean isAcessivel() {
        return acessivel;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public int getAltura() {
        return altura;
    }

    public TipoPonto getTipoPonto() {
        return tipoPonto;
    }

}
