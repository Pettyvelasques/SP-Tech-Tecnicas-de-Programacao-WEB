package school.sptech.teste_relacionamento.controller;

import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.teste_relacionamento.dto.aluno.AlunoCadastroDto;
import school.sptech.teste_relacionamento.dto.aluno.AlunoDetalhesDto;
import school.sptech.teste_relacionamento.dto.aluno.AlunoMapper;
import school.sptech.teste_relacionamento.dto.aluno.AlunoResumoDto;
import school.sptech.teste_relacionamento.dto.curso.CursoMapper;
import school.sptech.teste_relacionamento.dto.curso.CursoPorIdDto;
import school.sptech.teste_relacionamento.entity.Aluno;
import school.sptech.teste_relacionamento.service.AlunoService;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

//    @Autowired
    private final AlunoService service;
    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoResumoDto>> listagem(){
        List<Aluno> alunos = service.listar();

        if(alunos.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        //Metodo LP Style de fazer
//        List<AlunoResumoDto> dtos = new ArrayList<>();
//        for(Aluno alunoDaVez : alunos){
//            AlunoResumoDto alunoResumoDto = AlunoMapper.toResumoDto(alunoDaVez);
//
//            dtos.add(alunoResumoDto);
//        }

        List<AlunoResumoDto> dtos = alunos.stream()
                .map(AlunoMapper::toResumoDto)
                .toList();

//        return ResponseEntity.status(200).body(dtos);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDetalhesDto> buscarPorId(@PathVariable Integer id){
        /*
            Declarar endpoint
            Criar metodo no service
            DTO de resposta
            Mapper
         */
        Aluno entidade = service.buscarPorId(id);
        AlunoDetalhesDto alunoDetalhesDto = AlunoMapper.toDetalhesDto(entidade);
        return ResponseEntity.ok(alunoDetalhesDto);
    }

    @PostMapping
    public ResponseEntity<AlunoDetalhesDto> cadastrar(@RequestBody AlunoCadastroDto dto){
        Aluno alunoEntidade = AlunoMapper.toAlunoEntity(dto);
        Aluno alunoCadastrado = service.cadastrar(alunoEntidade, dto.getCursoId());
        AlunoDetalhesDto alunoDetalheDto = AlunoMapper.toDetalhesDto(alunoCadastrado);

//        return ResponseEntity.status(201).body(alunoDetalheDto);
        return ResponseEntity.created(null).body(alunoDetalheDto);
    }

    // localhost:8080/alunos/cursos/categorias?nome=xpto
    @GetMapping("/cursos/categorias")
    public ResponseEntity<List<AlunoDetalhesDto>> buscarPorCursoCategoria(@RequestParam String nome){
        List<Aluno> alunos = service.buscarPorCursoCategoria(nome);

        if(alunos.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        List<AlunoDetalhesDto> dtos = alunos.stream()
                .map(AlunoMapper::toDetalhesDto)
                .toList();

        return ResponseEntity.ok(dtos);
    }
}
