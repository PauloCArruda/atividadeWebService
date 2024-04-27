package org.example.repository;

import org.example.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository
        extends JpaRepository<Disciplina, Integer> {
}
