package school.sptech.teste_relacionamento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
