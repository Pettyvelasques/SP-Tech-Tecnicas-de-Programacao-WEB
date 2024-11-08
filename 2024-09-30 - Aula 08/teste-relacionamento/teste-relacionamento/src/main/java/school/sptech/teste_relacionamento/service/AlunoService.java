package school.sptech.teste_relacionamento.service;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import school.sptech.teste_relacionamento.entity.Aluno;
import school.sptech.teste_relacionamento.entity.Curso;
import school.sptech.teste_relacionamento.exception.EntidadeNaoEncontradaException;
import school.sptech.teste_relacionamento.repository.AlunoRepository;
import school.sptech.teste_relacionamento.repository.CursoRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoService {

//    @Autowired
private final AlunoRepository repository;
    private final CursoRepository cursoRepository;
    private final CursoService cursoService;
    private final AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> listar() { // IDEAL -> Paginado (200 - HTTP Status) - Page / Pageable
        return repository.findAll();
    }

    public Aluno buscarPorId(Integer id) {
        return alunoRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Aluno não encontrado")
        );

//        Optional<Aluno> opt = alunoRepository.findById(id);
//        if(opt.isPresent()){
//            return opt.get();
//        } else {
//            throw new EntidadeNaoEncontradaException("Aluno não encontrado")
//        }
    }

    public Aluno cadastrar(Aluno alunoEntidade, Integer cursoId) {
        Curso curso = cursoService.buscarPorId(cursoId);

        alunoEntidade.setCurso(curso);

        Aluno alunoCadastrado = alunoRepository.save(alunoEntidade);

        return alunoCadastrado;
    }

    public List<Aluno> buscarPorCursoCategoria(String categoria){
        return repository.findAllByCursoCategoria(categoria);
    }
}
