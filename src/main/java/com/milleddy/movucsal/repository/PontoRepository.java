package com.milleddy.movucsal.repository;


import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.entity.TipoPonto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Integer> {

    Ponto findByCodigo(String codigo);

    List<Ponto> findByTipoPonto(TipoPonto tipoPonto);
}
