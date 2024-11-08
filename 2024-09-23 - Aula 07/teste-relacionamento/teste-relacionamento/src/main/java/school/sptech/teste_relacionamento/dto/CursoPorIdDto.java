package school.sptech.teste_relacionamento.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CursoPorIdDto {
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;
    private String categoria;

    // Campo calculado ou campo virtual
    // Qdn gerar informacao e nao somento apresentar o dado
    public String getValorFormatado(){
        return "%.2f".formatted(preco);
    }
}
