package com.milleddy.movucsal.service;

import com.milleddy.movucsal.repository.PontoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;


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
    void shouldGetAllInterestPoints() {
        //when
        pontoService.getAll();

        //then
        verify(pontoRepository).findAll();
    }
}
