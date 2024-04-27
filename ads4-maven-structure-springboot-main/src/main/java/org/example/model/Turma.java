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
@Table(name = "TURMA")
/*jpa/hibernate*/
public class Turma {

    public void interfaceFluente(){
        Turma xpto = Turma.builder().ano(Integer.parseInt("")).semestre(Integer.parseInt("")).diaSemana(Integer.parseInt("")).horarios("").build();
    }

    //@Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //@Getter
    //@Setter
    @Column(name = "CURSO", length = 50, nullable = false)
    private int ano;
    private int semestre;
    private int diaSemana;
    private String horarios;
    private boolean ativo;

}
