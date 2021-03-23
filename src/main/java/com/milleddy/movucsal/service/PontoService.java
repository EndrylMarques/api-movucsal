package com.milleddy.movucsal.service;

import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.repository.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PontoService {

    PontoRepository pontoRepository;

    @Autowired
    public PontoService(PontoRepository pontoRepository) {
        this.pontoRepository = pontoRepository;
    }

    public List<Ponto> getAll() {
        return pontoRepository.findAll();
    }

    public Ponto getById(int id) {
        Optional<Ponto> ponto = pontoRepository.findById(id);

        return ponto.isPresent() ? ponto.get() : null;
    }
}
