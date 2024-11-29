package school.sptech.para_testar.presentation.dto.mapper;

import school.sptech.para_testar.persistence.entity.Aluno;
import school.sptech.para_testar.presentation.dto.AlunoRequestDto;
import school.sptech.para_testar.presentation.dto.AlunoResponseDto;

public class AlunoMapper {

    public static Aluno from(AlunoRequestDto alunoRequestDto) {

        if (alunoRequestDto == null) {
            return null;
        }

        return Aluno.builder()
                .nome(alunoRequestDto.getNome())
                .email(alunoRequestDto.getEmail())
                .dataNascimento(alunoRequestDto.getDataNascimento())
                .matricula(alunoRequestDto.getMatricula())
                .build();
    }

    public static AlunoResponseDto from(Aluno aluno) {

        if (aluno == null) {
            return null;
        }

        return AlunoResponseDto.builder()
                .id(aluno.getId())
                .nome(aluno.getNome())
                .email(aluno.getEmail())
                .dataNascimento(aluno.getDataNascimento())
                .matricula(aluno.getMatricula())
                .build();
    }
}
