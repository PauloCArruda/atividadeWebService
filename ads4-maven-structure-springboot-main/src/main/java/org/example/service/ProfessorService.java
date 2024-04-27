package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.Disciplina;
import org.example.model.Professor;
import org.example.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j //nos ajuda a escrever log no projeto
@Service //indica que é uma camada de serviço(negócio)
public class ProfessorService implements IService<Professor, Integer> {

    @Autowired
    private ProfessorRepository professorRepository;
    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Professor create(Professor entity) {
        return professorRepository.save(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */
    @Override
    public Professor get(Integer id) {
        return professorRepository.findById(id).orElse(new Professor());
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */
    @Override
    public List<Professor> get() {
        return professorRepository.findAll();
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
    public Professor update(Integer id, Professor entity) {
        Professor professorEncontrado = this.get(id);

        if(professorEncontrado.getId()!=0 || professorEncontrado.getId()!=null){
            return professorRepository.save(entity);
        }
        else{
            //return null;
            return new Professor();
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
        professorRepository.deleteById(id);
    }
}
