package school.sptech.ex_many_to_one_dto1.entity;

import jakarta.persistence.*;
import lombok.*;

// TODO: TERMINAR A CLASSE
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String tipo;
    private Double valorAtual;

    @ManyToOne
    private Carteira Carteira;


}
