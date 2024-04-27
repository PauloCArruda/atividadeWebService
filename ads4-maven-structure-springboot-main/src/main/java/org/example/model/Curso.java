package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lomok ajuda com os métodos: get,set,tostring, @equals
@Builder
@NoArgsConstructor
@AllArgsConstructor
/*lombok*/
/*jpa/hibernate*/
@Entity
@Table(name = "CURSO")
/*jpa/hibernate*/
public class Curso {

    public void interfaceFluente(){
        Curso xpto = Curso.builder().descricao("").build();
    }

    //@Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //@Getter
    //@Setter
    @Column(name = "CURSO", length = 50, nullable = false)
    private String descricao;

    private boolean ativo;

}
