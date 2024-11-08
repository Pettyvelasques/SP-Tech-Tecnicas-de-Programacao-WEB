package school.sptech.teste_relacionamento.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.teste_relacionamento.dto.CursoCadastroDto;
import school.sptech.teste_relacionamento.dto.CursoMapper;
import school.sptech.teste_relacionamento.dto.CursoPorIdDto;
import school.sptech.teste_relacionamento.dto.CursoResumoDto;
import school.sptech.teste_relacionamento.entity.Curso;
import school.sptech.teste_relacionamento.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoResumoDto> cadastro(
            @RequestBody @Valid CursoCadastroDto curso
            ) {
//            Precisaremos mapera o dto para entidade:
//            x - Construtor na entidade que recebe o DTO e retorna uma instancia de Curso(entidade);
//            x - Metodo na dto que gera uma instancia de Curso(entidade);
//            Melhor opção: Cria um mapper (classe que so faz isso);

        Curso cursoEntidade =  CursoMapper.toEntity(curso);
        Curso cursoSalvo = this.cursoService.cadastrar(cursoEntidade);
        CursoResumoDto resumoDto = CursoMapper.toResumoDto(cursoSalvo);
        return ResponseEntity.status(201).body(resumoDto);
    }

    @GetMapping
    public ResponseEntity<List<CursoResumoDto>> listagem() {
        List<Curso> listagem = cursoService.listar();
        if (listagem.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

//        JAVA STREAM API:
//            - MAP(MAPEAR UM OBJ PARA OUTRO)
//            - FILTER(FILTRAR UMA LISTA OU COLECAO DE OBJ)
//            - REDUCE (SUMARIZAR, ACUMULAR)
//        EXISTE INCLUSIVE NO JS;

        List<CursoResumoDto> listDto = listagem.stream()
    //                .map(curso -> {
    //                    return CursoMapper.toResumoDto(curso)
    //                })
                .map(CursoMapper::toResumoDto)
                .toList();

        return ResponseEntity.status(200).body(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoPorIdDto> buscarPorId(@PathVariable Integer id) {
        Curso curso = this.cursoService.buscarPorId(id);
        CursoPorIdDto cursoIdDto = CursoMapper.toCursoIdDto(curso);
        return ResponseEntity.status(200).body(cursoIdDto);
    }
}
