package br.com.movucsal.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_caminho")
public class Caminho {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "distancia")
    private double distancia;

    @ManyToOne
    @JoinColumn(name = "fk_ponto_origem")
    private Ponto pontoOrigem;

    @ManyToOne
    @JoinColumn(name = "fk_ponto_destino")
    private Ponto pontoDestino;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

