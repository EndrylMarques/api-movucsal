package com.milleddy.movucsal.service;

import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.entity.TipoPonto;
import com.milleddy.movucsal.repository.PontoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

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

        //when
        pontoService.getById(ponto.getId());

        //then
        verify(pontoRepository).findById(ponto.getId());
    }
}
