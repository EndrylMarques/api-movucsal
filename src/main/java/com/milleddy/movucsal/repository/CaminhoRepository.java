package com.milleddy.movucsal.repository;

import com.milleddy.movucsal.entity.Caminho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaminhoRepository extends JpaRepository<Caminho, Long> {

}
