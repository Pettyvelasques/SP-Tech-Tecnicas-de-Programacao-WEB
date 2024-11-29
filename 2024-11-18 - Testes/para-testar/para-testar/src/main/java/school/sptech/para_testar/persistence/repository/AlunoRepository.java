package school.sptech.para_testar.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.para_testar.persistence.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    boolean existsByEmailIgnoreCaseOrMatriculaIgnoreCase(String email, String matricula);
}
