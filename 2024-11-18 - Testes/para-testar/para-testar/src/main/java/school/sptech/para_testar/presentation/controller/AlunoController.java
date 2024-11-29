package school.sptech.para_testar.presentation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.para_testar.business.service.AlunoService;
import school.sptech.para_testar.persistence.entity.Aluno;
import school.sptech.para_testar.presentation.dto.AlunoRequestDto;
import school.sptech.para_testar.presentation.dto.AlunoResponseDto;
import school.sptech.para_testar.presentation.dto.mapper.AlunoMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoResponseDto>> listar() {
        List<Aluno> allAlunos = alunoService.getAllAlunos();

        if (allAlunos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<AlunoResponseDto> dtos = allAlunos.stream()
                .map(AlunoMapper::from)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> buscarPorId(@PathVariable Integer id) {
        Aluno aluno = alunoService.getAlunoById(id);
        AlunoResponseDto dto = AlunoMapper.from(aluno);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDto> criar(@RequestBody @Valid AlunoRequestDto aluno) {
        Aluno entity = AlunoMapper.from(aluno);
        Aluno created = alunoService.createAluno(entity);
        AlunoResponseDto dto = AlunoMapper.from(created);
        return ResponseEntity.status(201).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        alunoService.deleteAlunoById(id);
        return ResponseEntity.noContent().build();
    }
}
