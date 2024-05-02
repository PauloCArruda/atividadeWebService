package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

// retirar @Entity e @Table para evitar conflito

@MappedSuperclass // indica uma super classe que fornece atributos comuns (Aluno e Professor)
public class Pessoa {

    public void interfaceFluente(){
        Pessoa pessoaBuilder = Pessoa.builder().nome("").endereco("").telefone("").build();
    }


    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    @NotBlank(message = "O Endereço é obrigatória")
    @Column(name = "ENDERECO", length = 100, nullable = false)
    private String endereco;

    @Column(name = "TELEFONE", length = 20, nullable = false)
    private String telefone;

}


