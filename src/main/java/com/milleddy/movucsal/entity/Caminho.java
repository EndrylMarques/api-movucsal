package com.milleddy.movucsal.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_caminho")
public class Caminho {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "distancia")
    private double distancia;

    @OneToOne
    @JoinColumn(name = "fk_ponto_origem")
    private Ponto pontoOrigem;

    @OneToOne
    @JoinColumn(name = "fk_ponto_destino")
    private Ponto pontoDestino;

    public Caminho(double distancia, Ponto pontoOrigem, Ponto pontoDestino) {
        this.distancia = distancia;
        this.pontoOrigem = pontoOrigem;
        this.pontoDestino = pontoDestino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Ponto getPontoOrigem() {
        return pontoOrigem;
    }

    public void setPontoOrigem(Ponto pontoOrigem) {
        this.pontoOrigem = pontoOrigem;
    }

    public Ponto getPontoDestino() {
        return pontoDestino;
    }

    public void setPontoDestino(Ponto pontoDestino) {
        this.pontoDestino = pontoDestino;
    }
}

