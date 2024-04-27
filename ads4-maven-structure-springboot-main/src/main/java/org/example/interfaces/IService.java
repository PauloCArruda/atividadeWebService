package org.example.interfaces;

import java.util.List;

/**
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/generics/types.html">Generics Java</a>
 * T - Type (Pode ser qualquer coisa = Pessoa, Aluno (geralmente camada Model)
 * N - Number (Integer, Double, etc; Geralmente é um wrapper)
 *
 * Iremos fazer o CRUD
 * create -> post > 1 registro
 * read -> get > 1 registro (id) ou n registros (lista)
 * update ->put (atualiza tudo), patch (atualiza parte)
 *         >  identificar o registro(id), precisamos do objeto para ser atualizado;
 * delete -> delete
 *
 */
public interface IService<T, N> extends GenericOperations<T, N> {

}
