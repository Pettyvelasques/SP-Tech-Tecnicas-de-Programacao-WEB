package school.sptech.para_testar.presentation.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AlunoResponseDto {
    private Integer id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String matricula;
}
