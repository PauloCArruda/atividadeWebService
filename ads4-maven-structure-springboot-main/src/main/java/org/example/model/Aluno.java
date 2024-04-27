package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*lombok*/
@Data //lomok ajuda com os métodos: get,set,tostring, @equals
@Builder
@NoArgsConstructor
@AllArgsConstructor
/*lombok*/
/*jpa/hibernate*/
@Entity
@Table(name = "ALUNO")
/*jpa/hibernate*/
public class Aluno {


    /**
     * @see <a href="https://en.wikipedia.org/wiki/Fluent_interface">Interface Fluent</a>
     */
    public void interfaceFluente(){
        Aluno xpto = Aluno.builder().matricula("").situacao("").build();
    }

    //@Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //@Getter
    //@Setter

    @Column(name = "ALUNO", length = 50, nullable = false)

    private String matricula;
    private String situacao;
    private boolean ativo;

}
