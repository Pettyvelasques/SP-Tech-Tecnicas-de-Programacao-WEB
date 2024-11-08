package school.sptech.teste_relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.teste_relacionamento.entity.Aluno;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
