package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data //lomok ajuda com os métodos: get,set,tostring, @equals
@Builder
@NoArgsConstructor
@AllArgsConstructor
/*lombok*/
/*jpa/hibernate*/
@Entity
@Table(name = "PROFESSOR")
/*jpa/hibernate*/
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //@Getter
    //@Setter
    @Column(name = "PROFESSOR", length = 50, nullable = false)
    private String titulacaoMaxima;
    private boolean ativo;
}
