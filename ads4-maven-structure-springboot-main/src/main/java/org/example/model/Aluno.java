package org.example.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "ALUNO")
public class Aluno extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name = "MATRICULA", length = 50, nullable = false)
    private String matricula;

    @Column(name = "SITUACAO", length = 50, nullable = false)
    private String situacao;

}
