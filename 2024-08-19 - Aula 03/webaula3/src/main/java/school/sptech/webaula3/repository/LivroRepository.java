package school.sptech.webaula3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.webaula3.entity.Livro;

import java.time.LocalDate;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    List<Livro> findByTituloContainingIgnoreCase(String titulo);

    List<Livro> findByNomeAutor(String nome);

    List<Livro> findByDataLancamentoAfter(LocalDate data);

    List<Livro> findByDataLancamentoBetween(LocalDate inicio, LocalDate fim);

    long countByNomeAutor(String nome);

    List<Livro> findByTituloIgnoreCaseAndDataLancamentoEquals(String nome, LocalDate data);
}
