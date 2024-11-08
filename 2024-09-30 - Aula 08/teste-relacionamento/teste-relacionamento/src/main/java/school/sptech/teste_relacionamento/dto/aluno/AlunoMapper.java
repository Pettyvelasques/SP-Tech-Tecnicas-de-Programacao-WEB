package school.sptech.teste_relacionamento.dto.aluno;

import school.sptech.teste_relacionamento.entity.Aluno;
import school.sptech.teste_relacionamento.entity.Curso;

public class AlunoMapper {
    public static AlunoResumoDto toResumoDto( Aluno entity){
        if (entity == null){
            return null;
        }

        return AlunoResumoDto.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .build(); //Constroi
    }

    public static AlunoDetalhesDto toDetalhesDto(Aluno entity){
        if (entity == null){
            return null;
        }

        Curso curso = entity.getCurso();

        AlunoDetalhesDto.AlunoCursoDto cursoDto = // monta objeto aninhado do curso dto
                AlunoDetalhesDto.AlunoCursoDto.builder()
                        .id(curso.getId())
                        .nome(curso.getNome())
                        .descricao(curso.getDescricao())
                        .preco(curso.getPreco())
                        .categoria(curso.getCategoria())
                        .build();

        return AlunoDetalhesDto.builder() // monta o obj root (objeto que é composto pelo obj aninhado)
                .id(entity.getId())
                .nome(entity.getNome())
                .cpf(entity.getCpf())
                .dataNascimento(entity.getDataNascimento())
                .curso(cursoDto) //utilizamos o objeto acima
                .build();
    }

    public static Aluno toAlunoEntity( AlunoCadastroDto dto){
        if (dto == null){
            return null;
        }

        return Aluno.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .dataNascimento(dto.getDataNascimento())
                .build();
    }

}
