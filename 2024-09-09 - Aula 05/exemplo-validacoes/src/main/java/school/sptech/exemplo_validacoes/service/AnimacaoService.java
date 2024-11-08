package school.sptech.exemplo_validacoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.exemplo_validacoes.entity.Animacao;
import school.sptech.exemplo_validacoes.repository.AnimacaoRepository;

import java.util.List;
import java.util.Optional;

@Service // modelo anemico(do Spring) -> as validacoes são feitas fora do objeto
public class AnimacaoService {

    @Autowired
    private AnimacaoRepository repository;

    public List<Animacao> listar(){
        return repository.findAll();
    }

    public Animacao cadastrar(Animacao animacao){
        //regra de validar cpf igual vai aqui
        return repository.save(animacao);
    }

    public Animacao buscarPorId(int id){
//        //encontrar a animacao
//        //não encontrar a animacao
//        Optional<Animacao>animacao = repository.findById(id);
//        if(animacao.isPresent()){
//            return animacao.get();
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Animação não encontrada");
////        return null;


        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Animação não encontrada");
        );
    }
}
