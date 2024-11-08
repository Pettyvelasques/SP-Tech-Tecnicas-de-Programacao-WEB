package school.sptech.ex_many_to_one_dto1.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.ex_many_to_one_dto1.entity.Ativo;
import school.sptech.ex_many_to_one_dto1.entity.Carteira;
import school.sptech.ex_many_to_one_dto1.exception.NaoEncontradoException;
import school.sptech.ex_many_to_one_dto1.repository.AtivoRepository;
import school.sptech.ex_many_to_one_dto1.repository.CarteiraRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AtivoService {

    private final AtivoRepository repository;
    private final CarteiraRepository carteiraRepository;
    private final CarteiraService carteiraService;

    public Ativo salvar(Ativo ativo, Integer carteiraId){
        Carteira carteira = carteiraService.buscarPorId(carteiraId);
        ativo.setCarteira(carteira);
        Ativo ativoCadastrado = repository.save(ativo);
        return ativoCadastrado;
    }

//    @GetMapping
    public List<Ativo> buscarTodos(){
        return repository.findAll();
    }

    public Ativo buscarPorId(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new NaoEncontradoException("O ativo retornado deve estar associado a uma carteira")
        );
    }

    public void deletarPorId(Integer id){
        if(repository.existsById(id)) {
            this.repository.deleteById(id);
        }else{
            throw new NaoEncontradoException("Ativo de id: "+id+" não encontrado");
        }
    }

    public List<Ativo> buscarAtivosPorInvestidorNome(String nome){
//        Carteira carteira = carteiraRepository.findAllByInvestidor(nome);
        return repository.findAllByCarteiraInvestidor(nome);
    }

    public Double buscarMediaAtivosPorInvestidorNome(String nome){
//        Carteira carteira = carteiraRepository.findAllByInvestidor(nome);
        List<Ativo> ativos = repository.findAllByCarteiraInvestidor(nome);


    }
}
