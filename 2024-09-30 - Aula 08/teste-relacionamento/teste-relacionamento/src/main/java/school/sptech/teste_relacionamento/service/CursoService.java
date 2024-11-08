package school.sptech.teste_relacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.teste_relacionamento.entity.Curso;
import school.sptech.teste_relacionamento.exception.EntidadeNaoEncontradaException;
import school.sptech.teste_relacionamento.repository.CursoRepository;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public Curso cadastrar(Curso cursoParaCadastro) {
        return repository.save(cursoParaCadastro);
    }

    public List<Curso> listar() {
        return repository.findAll();
    }

    public Curso buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Curso de is %d não encontrado".formatted(id))
        );
    }
}
