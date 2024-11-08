package sptech.school.continuada2.dto.personagem;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PersonagemCreateDto {
    //TODO: Implementar validações
    @NotBlank
    private String nome;
    @NotBlank
    private String ultimate;
    @NotBlank
    private String funcaoPrincipal;
    @NotNull
    @Positive
    private int regiaoId;
}
