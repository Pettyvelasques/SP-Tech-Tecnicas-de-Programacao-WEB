package school.sptech.teste_relacionamento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter // Get
@Setter // Set
@AllArgsConstructor // Construtor Cheio
@NoArgsConstructor // Construtor vazio
// Não utilizar o @Data do lombok em entidade
@Builder //Padrão de projeto (criacional), é um padrão de projeto utilizado para criar objeto já parametrizado, ex:
// Curso build = Curso.builder()
// .id(1)
// .nome("Teste")
// .build();
//@ToString
//@RequiredArgsConstructor // Gera um contrutor que contem somente args constantes
public class Curso {

    /*
    Cuidado ao usar Lombox
    Mapper Struct (Recomendada) - > Importar uma configuração

     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;
    private String categoria; //enumerador


}
