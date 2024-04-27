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
@Table(name = "PESSOA")
/*jpa/hibernate*/
public class Pessoa {

    public void interfaceFluente(){
        Pessoa xpto = Pessoa.builder().nome("").endereco("").telefone("").build();
    }

    //@Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //@Getter
    //@Setter
    @Column(name = "PESSOA", length = 50, nullable = false)
    private String nome;
    private String endereco ;
    private String telefone;
    private boolean ativo;

}
