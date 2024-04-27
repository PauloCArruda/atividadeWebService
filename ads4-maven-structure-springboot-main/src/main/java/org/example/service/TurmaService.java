package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.Curso;
import org.example.model.Turma;
import org.example.repository.CursoRepository;
import org.example.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j //nos ajuda a escrever log no projeto
@Service //indica que é uma camada de serviço(negócio)
public class TurmaService implements IService<Turma, Integer> {

    @Autowired //injeção de dependência
    private TurmaRepository turmaRepository;

    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Turma create(Turma entity) {
        return turmaRepository.save(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */
    @Override
    public Turma get(Integer id) {
        Optional<Turma> turmaEncontrado = turmaRepository.findById(id);
        if(turmaEncontrado.isPresent()){
            return turmaEncontrado.get(); //pega o objeto dentro do Optional e devolve para a classe que o chamou
        }
        else {
            return new Turma(); //não encontrei o aluno;
        }
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */
    @Override
    public List<Turma> get() {
        return turmaRepository.findAll();
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
    public Turma update(Integer id, Turma entity) {

        Turma turmaEncontrado = this.get(id);

        if(turmaEncontrado.getId()!=0 || turmaEncontrado.getId()!=null){
            return turmaRepository.save(entity);
        }
        else{
            //return null;
            return new Turma();
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
        turmaRepository.deleteById(id);
    }
}
