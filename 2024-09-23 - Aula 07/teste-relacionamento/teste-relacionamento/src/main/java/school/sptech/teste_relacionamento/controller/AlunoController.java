package school.sptech.teste_relacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.teste_relacionamento.entity.Aluno;
import school.sptech.teste_relacionamento.repository.AlunoRepository;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public ResponseEntity<List<Aluno>> listagem(){
        List<Aluno> alunos = repository.findAll();

        if(alunos.isEmpty()){
    return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(alunos);
    }
}
