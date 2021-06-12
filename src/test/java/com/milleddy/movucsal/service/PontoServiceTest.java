package com.milleddy.movucsal.service;

import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.entity.TipoPonto;
import com.milleddy.movucsal.repository.PontoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class PontoServiceTest {
    @Mock
    PontoRepository pontoRepository;

    private PontoService pontoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pontoService = new PontoService(pontoRepository);
    }

    @Test
    void getAllDeveRetornarTodosOsPontosDoBanco() {
        //when
        pontoService.getAll();

        //then
        verify(pontoRepository).findAll();
    }

    @Test
    void getByIdDeveRetornarPonto() {
        Ponto ponto = new Ponto(1, "TES", "Teste 1", 'B', true,
                "23.4", "45.7", 1, TipoPonto.SALA);

        when(pontoRepository.findById(ponto.getId())).thenReturn(Optional.of(ponto));

        var result = pontoService.getById(ponto.getId());

        verify(pontoRepository).findById(ponto.getId());
        assertEquals(ponto, result);
    }

    @Test
    void getByTipoPontoDeveRetornarLista() {
        Ponto ponto = new Ponto(1, "TES", "Teste 1", 'B', true,
                "23.4", "45.7", 1, TipoPonto.SALA);

       var expectedList = Collections.singletonList(ponto);

        when(pontoRepository.findByTipoPonto(ponto.getTipoPonto()))
                .thenReturn(expectedList);

        var result = pontoService.getByTipoPonto(TipoPonto.SALA);

        verify(pontoRepository).findByTipoPonto(TipoPonto.SALA);
        assertEquals(expectedList, result);
    }
}
