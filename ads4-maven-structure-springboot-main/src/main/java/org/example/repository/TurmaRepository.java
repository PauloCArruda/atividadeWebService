package org.example.repository;

import org.example.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository
        extends JpaRepository<Turma, Integer> {
}