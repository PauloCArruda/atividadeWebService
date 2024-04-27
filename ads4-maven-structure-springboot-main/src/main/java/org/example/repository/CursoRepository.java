package org.example.repository;

import org.example.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository
        extends JpaRepository<Curso, Integer> {
}