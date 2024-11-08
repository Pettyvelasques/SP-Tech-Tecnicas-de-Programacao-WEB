package sptech.school.continuada2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.continuada2.entity.Personagem;

import java.util.List;
import java.util.Optional;

public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {

    //TODO: Implementar as consultas personalizadas
    Optional<Personagem> findAllByRegiaoId(Integer id);

    List<Personagem> findByFuncaoPrincipalAndRegiaoSigla(String funcaoPrincipal, String sigla);

    List<Personagem> findByRegiaoNomeContainingIgnoreCase(String nome);
}
