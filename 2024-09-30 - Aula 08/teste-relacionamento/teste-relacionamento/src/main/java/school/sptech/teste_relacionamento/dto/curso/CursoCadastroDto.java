package school.sptech.teste_relacionamento.dto.curso;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
public class CursoCadastroDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    private Double preco;
    private String categoria;
}
