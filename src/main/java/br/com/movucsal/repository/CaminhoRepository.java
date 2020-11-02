package br.com.movucsal.repository;

import br.com.movucsal.entity.Caminho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaminhoRepository extends JpaRepository<Caminho, Long> {

}
