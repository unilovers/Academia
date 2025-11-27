package com.unilopers.academia.repository;

import com.unilopers.academia.model.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Long> {
    List<Presenca> findByAlunoIdOrderByEntradaDesc(Long alunoId);
}
