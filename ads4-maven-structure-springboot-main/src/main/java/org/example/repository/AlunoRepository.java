package org.example.repository;

import org.example.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository
        extends JpaRepository<Aluno, Integer> {
}
