package com.milleddy.movucsal.service;

import com.milleddy.movucsal.entity.Caminho;
import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.entity.TipoPonto;
import com.milleddy.movucsal.repository.CaminhoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.parameters.P;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.List;

public class MapaServiceTest {

    private List<Ponto> pontos = new ArrayList<>();
    private List<Caminho> caminhos = new ArrayList<>();

    @Mock
    private CaminhoRepository caminhoRepository;

    private MapaService mapaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mapaService = new MapaService(caminhoRepository);
        setUpPontos();
        setUpCaminhos();
    }

    @Test
    void shouldReturnAdjacentPoints() {
        when(caminhoRepository.findAll()).thenReturn(caminhos);

        var vizinhos = mapaService.getPontosAdjacentes(1);

        assertThat(vizinhos.size(), is(1));
    }

    @Test
    void shouldReturnAllPaths() {
        mapaService.getCaminhos();
        verify(caminhoRepository).findAll();
    }

    @Test
    void shouldReturnRealDistanceBetweenTwoPoints() {
        when(caminhoRepository.findAll()).thenReturn(caminhos);
        var distancia = mapaService.getDistanciaReal(pontos.get(0), pontos.get(1));

        assertThat(distancia, is(1.5));
    }



    private List<Caminho> setUpCaminhos() {
        Caminho caminho = new Caminho(1.5, pontos.get(0), pontos.get(1));
        caminhos.add(caminho);
        caminho = new Caminho(4, pontos.get(1), pontos.get(2));
        caminhos.add(caminho);
        caminho = new Caminho(2, pontos.get(2), pontos.get(3));
        caminhos.add(caminho);

        return caminhos;
    }

    private List<Ponto> setUpPontos(){
        Ponto ponto = new Ponto(1, "LA1","Lami 1", 'B', true,
                -12.948061d, -38.412990d, 4, TipoPonto.LAMI);
        pontos.add(ponto);
        ponto = new Ponto(2, "LA2", "Lami 2", 'B', true,
                -12.948068, -38.412985, 4, TipoPonto.LAMI);
        pontos.add(ponto);
        ponto = new Ponto(3, "LA3", "Lami 3", 'B', true,
                -12.948085, -38.412984, 4, TipoPonto.LAMI);
        pontos.add(ponto);
        ponto = new Ponto(4, "BF1", "Banheiro Feminino", 'B', true,
                -12.948101, -38.412982, 4, TipoPonto.BANHEIRO_FEMININO);
        pontos.add(ponto);

        return pontos;
    }
}
