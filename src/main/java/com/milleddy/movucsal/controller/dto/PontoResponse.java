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

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public char getPredio() {
        return predio;
    }

    public void setPredio(char predio) {
        this.predio = predio;
    }

    public boolean isAcessivel() {
        return acessivel;
    }

    public void setAcessivel(boolean acessivel) {
        this.acessivel = acessivel;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public TipoPonto getTipoPonto() {
        return tipoPonto;
    }

    public void setTipoPonto(TipoPonto tipoPonto) {
        this.tipoPonto = tipoPonto;
    }
}
