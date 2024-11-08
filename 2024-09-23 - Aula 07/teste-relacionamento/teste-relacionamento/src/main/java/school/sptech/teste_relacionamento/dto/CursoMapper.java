package school.sptech.teste_relacionamento.dto;

import school.sptech.teste_relacionamento.entity.Curso;

import java.util.Objects;

public class CursoMapper {
    public static Curso toEntity(CursoCadastroDto dto){
        if (dto == null){
            return null;
        }

        return Curso.builder()
                .nome(dto.getNome())
                .categoria(dto.getCategoria())
                .descricao(dto.getDescricao())
                .preco(dto.getPreco())
                .build();
    }

    public static CursoResumoDto toResumoDto(Curso entidade){

        if(entidade == null){
            return null;
        }
       return CursoResumoDto.builder()
                .id(entidade.getId())
                .nome(entidade.getNome())
                .build();
    }

    public static CursoPorIdDto toCursoIdDto(Curso entidade){
        if(Objects.isNull(entidade)){
            return null;
        }

        CursoPorIdDto porIdDto = new CursoPorIdDto();

        porIdDto.setId(entidade.getId());
        porIdDto.setNome(entidade.getNome());
        porIdDto.setDescricao(entidade.getDescricao());
        porIdDto.setPreco(entidade.getPreco());
        porIdDto.setCategoria(entidade.getCategoria());

        return porIdDto;
    }
}
