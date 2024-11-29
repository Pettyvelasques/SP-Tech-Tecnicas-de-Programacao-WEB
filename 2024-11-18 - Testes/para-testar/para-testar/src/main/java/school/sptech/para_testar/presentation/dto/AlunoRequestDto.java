package school.sptech.para_testar.presentation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoRequestDto {

    @NotBlank
    private String nome;
    @Email
    @NotBlank
    private String email;
    @Past
    @NotNull
    private LocalDate dataNascimento;
    @NotBlank
    @Pattern(regexp = "^[0-9]{6}$", message = "A matrícula deve conter 6 dígitos")
    private String matricula;
}
