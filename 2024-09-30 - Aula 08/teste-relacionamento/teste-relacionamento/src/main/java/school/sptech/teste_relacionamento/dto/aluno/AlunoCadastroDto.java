package school.sptech.teste_relacionamento.dto.aluno;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class AlunoCadastroDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @Past
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    @Positive
    private Integer cursoId;

}
