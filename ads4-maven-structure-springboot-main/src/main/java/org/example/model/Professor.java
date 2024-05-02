package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PROFESSOR")
public class Professor extends Pessoa {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "A titulação máxima do professor é obrigatória")
    @Column(name = "TITULACAOMAX", length = 50, nullable = false)
    private String titulacaomax;


}
