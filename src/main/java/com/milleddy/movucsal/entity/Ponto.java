package com.milleddy.movucsal.entity;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "tb_ponto")
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

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

    @Column(name = "latitude")
    @CsvBindByName(column = "Latitude")
    private double latitude;

    @Column(name = "longitude")
    @CsvBindByName(column = "Longitude")
    private double longitude;

    @Column(name = "altura")
    @CsvBindByName(column = "Altura")
    private int altura;

    public Ponto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
