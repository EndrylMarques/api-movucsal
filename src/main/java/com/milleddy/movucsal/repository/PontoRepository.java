package com.milleddy.movucsal.repository;


import com.milleddy.movucsal.entity.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Integer> {
}
