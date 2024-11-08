package school.sptech.ex_many_to_one_dto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.ex_many_to_one_dto1.entity.Ativo;
import school.sptech.ex_many_to_one_dto1.entity.Carteira;

import java.util.List;

// TODO: TERMINAR A CLASSE
public interface AtivoRepository extends JpaRepository<Ativo, Integer> {

    List<Ativo> findAllByCarteiraInvestidor(String nome);
}
