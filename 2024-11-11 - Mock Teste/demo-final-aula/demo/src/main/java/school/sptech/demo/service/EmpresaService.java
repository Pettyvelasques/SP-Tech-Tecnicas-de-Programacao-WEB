package school.sptech.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.demo.entity.Empresa;
import school.sptech.demo.exception.ConflitoException;
import school.sptech.demo.exception.EntidadeNaoEncontradaException;
import school.sptech.demo.repository.EmpresaRepository;

import java.util.List;

@Service // Indica que esta classe é um componente de serviço na camada de negócios (Business)
@RequiredArgsConstructor // Gera automaticamente um construtor com argumentos para os atributos finais (final)
public class EmpresaService {

    // Injeção de dependência do repositório de empresas para interação com o banco de dados
    private final EmpresaRepository empresaRepository;

    /*
        Camadas do sistema:
        Business -> Representa a camada de negócio (Service, Use case...) onde estão as regras de negócio.
        Persistence -> Camada de persistência (ou banco de dados), que armazena e consulta dados.
        View -> Camada de exposição, responsável pela interação com o usuário e apresentação de dados.
    */

    // O método buscarTodos usa o repositório para buscar e retornar todas as empresas do banco de dados.
    public List<Empresa> buscarTodos() {
        return this.empresaRepository.findAll();
    }

    // O método buscarPorId busca uma empresa específica pelo ID.
    public Empresa buscarPorId(Integer id) {

        /*
            Exemplo usando Optional:
            O método findById retorna um Optional, que representa um valor que pode ou não estar presente.
            Abaixo está um exemplo completo de como utilizar Optional:

            Optional<Empresa> resultado = this.empresaRepository.findById(id);

            if (resultado.isEmpty()) { // Verifica se o Optional está vazio (empresa não encontrada)
                throw new EntidadeNaoEncontradaException("Empresa não encontrada");
            }

            return resultado.get(); // Retorna o valor da empresa, se presente
        */

        // Aqui, usamos orElseThrow para lançar uma exceção se a empresa não for encontrada
        return this.empresaRepository.findById(id)
                .orElseThrow(
                        () -> new EntidadeNaoEncontradaException("Empresa não encontrada.") // Exceção customizada
                );
    }

    // O método cadastrar recebe uma empresa e verifica se já existe uma com o mesmo CNPJ no banco.
    public Empresa cadastrar(Empresa empresa) {

        // Verifica se já existe uma empresa com o CNPJ informado, ignorando letras maiúsculas/minúsculas
        if (empresaRepository.existsByCnpjIgnoreCase(empresa.getCnpj())) {
            throw new ConflitoException("Já existe uma empresa com o CNPJ informado"); // Exceção de conflito
        }

        // Salva e retorna a empresa cadastrada no banco de dados
        return empresaRepository.save(empresa);
    }
}
