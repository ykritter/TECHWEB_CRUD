package br.com.senac.service;

import java.util.List;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Curso;
import br.com.senac.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    CursoRepository repo;

    public List<Curso> buscarTodosCursos(){
        return repo.findAll();
    }

    public Curso salvarAlteracao(Curso cursoAlterado){
            Curso curso = this.buscarCursoId(cursoAlterado.getId());
            curso.setNome(cursoAlterado.getNome());
            curso.setProfessor(cursoAlterado.getProfessor());
            return salvar(curso);
        }
        
    public Curso salvar(Curso curso){
        return repo.save(curso);
    }
    
    public void deletarCursoId(Integer id){
        repo.deleteById(id);
    }

    public Curso buscarCursoId(Integer id) throws ObjectNotFoundException{
        Optional<Curso> Curso = repo.findById(id);

        return Curso.orElseThrow( () -> new ObjectNotFoundException(1L, "Curso não encontrado"));
    }

    

    
    
}
