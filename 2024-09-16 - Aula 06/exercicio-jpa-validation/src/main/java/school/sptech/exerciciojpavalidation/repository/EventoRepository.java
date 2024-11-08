package school.sptech.exerciciojpavalidation.repository;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exerciciojpavalidation.entity.Evento;

import java.time.LocalDate;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
    List<Evento> findAllByGratuito(Boolean b);

    List<Evento> findByDataEventoOrDataPublicacao(LocalDate dataEvento, LocalDate dataPublicacao);

}
