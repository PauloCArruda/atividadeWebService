package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.Curso;
import org.example.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j //nos ajuda a escrever log no projeto
@Service //indica que é uma camada de serviço(negócio)
public class CursoService implements IService<Curso, Integer> {

    @Autowired //injeção de dependência
    private CursoRepository cursoRepository;

    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Curso create(Curso entity) {
        return cursoRepository.save(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */
    @Override
    public Curso get(Integer id) {
        Optional<Curso> cursoEncontrado = cursoRepository.findById(id);
        if(cursoEncontrado.isPresent()){
            return cursoEncontrado.get(); //pega o objeto dentro do Optional e devolve para a classe que o chamou
        }
        else {
            return new Curso(); //não encontrei o aluno;
        }
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */
    @Override
    public List<Curso> get() {
        return cursoRepository.findAll();
    }

    /**
     * Iremos passar N(id) para buscar o registro e T(entity) para atualizar o objeto;
     *
     * @param id
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Curso update(Integer id, Curso entity) {

        Curso cursoEncontrado = this.get(id);

        if(cursoEncontrado.getId()!=0 || cursoEncontrado.getId()!=null){
            return cursoRepository.save(entity);
        }
        else{
            //return null;
            return new Curso();
        }
    }

    /**
     * Deleta um registro com base no identificador N(id)
     *
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        cursoRepository.deleteById(id);
    }
}
