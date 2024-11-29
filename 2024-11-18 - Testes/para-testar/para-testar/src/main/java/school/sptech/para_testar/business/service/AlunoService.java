package school.sptech.para_testar.business.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.para_testar.business.exception.ConflitoException;
import school.sptech.para_testar.business.exception.EntidadeNaoEncontradaException;
import school.sptech.para_testar.persistence.entity.Aluno;
import school.sptech.para_testar.persistence.repository.AlunoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository repository;

    public Aluno createAluno(Aluno aluno) {
        if (repository.existsByEmailIgnoreCaseOrMatriculaIgnoreCase(
                aluno.getEmail(), aluno.getMatricula())
        ) {
            throw new ConflitoException("Email e/ou matricula devem ser únicos");
        }

        return repository.save(aluno);
    }

    public Aluno getAlunoById(Integer id) {
        return this.repository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Aluno não encontrado")
        );
    }

    public void deleteAlunoById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("Aluno não encontrado");
        }
    }

    public List<Aluno> getAllAlunos() {
        return repository.findAll();
    }
}
