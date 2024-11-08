package school.sptech.teste_relacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.teste_relacionamento.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;
}
