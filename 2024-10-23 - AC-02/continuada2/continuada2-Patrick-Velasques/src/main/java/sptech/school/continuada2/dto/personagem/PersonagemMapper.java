package sptech.school.continuada2.dto.personagem;

import sptech.school.continuada2.entity.Personagem;
import sptech.school.continuada2.entity.Regiao;

public class PersonagemMapper {

    public static Personagem toEntity(PersonagemCreateDto dto) {

        if (dto == null) {
            return null;
        }

        // TODO: Implementar mapeamento de PersonagemCreateDto para Personagem
        return Personagem.builder()
                // TODO: Completar o de-para dos atributos
                .nome(dto.getNome())
                .ultimate(dto.getUltimate())
                .funcaoPrincipal(dto.getFuncaoPrincipal())
                .build();
    }

    public static PersonagemResponseDto toDto(Personagem entity) {

        if (entity == null) {
            return null;
        }

        Regiao regiaoEntidade = entity.getRegiao();

        // TODO: Implementar mapeamento de Regiao para RegiaoPersonagemResponseDto (classe interna de PersonagemResponseDto)
        PersonagemResponseDto.RegiaoPersonagemResponseDto regiaoDto =
                PersonagemResponseDto.RegiaoPersonagemResponseDto.builder()
                        // TODO: Completar o de-para dos atributos
                        .id(regiaoEntidade.getId())
                        .nome(regiaoEntidade.getNome())
                        .descricao(regiaoEntidade.getDescricao())
                        .sigla(regiaoEntidade.getSigla())
                        .build();

        // TODO: Implementar mapeamento de Personagem para PersonagemResponseDto
        return PersonagemResponseDto.builder()
                // TODO: Completar o de-para dos atributos
                .regiao(regiaoDto)
                .id(entity.getId())
                .nome(entity.getNome())
                .ultimate(entity.getUltimate())
                .funcaoPrincipal(entity.getFuncaoPrincipal())
                .build();
    }
}
