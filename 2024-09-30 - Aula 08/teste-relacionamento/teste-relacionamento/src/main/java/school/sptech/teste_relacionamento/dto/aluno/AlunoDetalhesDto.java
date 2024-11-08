package school.sptech.teste_relacionamento.dto.aluno;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class AlunoDetalhesDto {
    private Integer id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private AlunoCursoDto curso;

//    Não fazer para não misturar classes
//    private Curso curso;

    // é a mesma coisa que criar uma classe em outro arquivo
    //@Builder do lombok só funciona em classe estatica
    @Data
    @Builder
    public static class AlunoCursoDto{
        private Integer id;
        private String nome;
        private String descricao;
        private Double preco;
        private String categoria; //enumerador
    }
}
