package com.milleddy.movucsal.entity;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "tb_ponto")
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "codigo")
    @CsvBindByName(column = "Codigo")
    private String codigo;

    @Column(name = "descricao")
    @CsvBindByName(column = "Description")
    private String descricao;

    @Column(name = "predio")
    @CsvBindByName(column = "Predio")
    private char predio;

    @Column(name = "acessivel")
    @CsvBindByName(column = "Acessivel")
    private boolean acessivel;

    //todo: add Coordenadas.java?
    @Column(name = "latitude")
    @CsvBindByName(column = "Latitude")
    private String latitude;

    @Column(name = "longitude")
    @CsvBindByName(column = "Longitude")
    private String longitude;

    @Column(name = "altura")
    @CsvBindByName(column = "Altura")
    private int altura;

    @Column(name = "tipoPonto")
    private TipoPonto tipoPonto;

    public Ponto() {
    }

    public Ponto(int id, String codigo, String descricao, char predio, boolean acessivel, String latitude, String longitude, int altura, TipoPonto tipoPonto) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.predio = predio;
        this.acessivel = acessivel;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altura = altura;
        this.tipoPonto = tipoPonto;
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
}
