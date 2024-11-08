package school.sptech.exemplo_validacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exemplo_validacoes.entity.Animacao;

public interface AnimacaoRepository extends JpaRepository<Animacao, Integer> {

}
