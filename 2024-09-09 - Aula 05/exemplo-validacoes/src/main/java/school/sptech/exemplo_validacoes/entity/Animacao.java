package school.sptech.exemplo_validacoes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.*;

import java.time.LocalDate;

@Entity
public class Animacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    NOTBLANK é a juncao do not null, not blank e not empty
//    @NotNull
    @NotBlank
    @Size(min = 2, max = 10)
    private String nome;

//    @Negative
//    @NegativeOrZero
//    @PositiveOrZero
    @Positive
    @NotNull
    @Min(10)
    @Max(100)
    @Range
    private Integer quantidadeEpisodios;

    @PastOrPresent
//    @Past
//    @Future
//    @FutureOrPresent
    private LocalDate dataEstreia;

    @CNPJ
    private String cnpjEmpresaResponsavel;
    @DecimalMax(value = "1000.0")
    @DecimalMin(value = "50.0")
    @Digits(integer=4,fraction=2)
    private Double faturamento;

    private String diretor;

    @CPF
    private String cpfDiretor;

//    @Email //só valida @
//    private String emailDiretor;

    public Animacao(Integer id, String nome, Integer quantidadeEpisodios, LocalDate dataEstreia, String cnpjEmpresaResponsavel, Double faturamento, String diretor, String cpfDiretor) {
        this.id = id;
        this.nome = nome;
        this.quantidadeEpisodios = quantidadeEpisodios;
        this.dataEstreia = dataEstreia;
        this.cnpjEmpresaResponsavel = cnpjEmpresaResponsavel;
        this.faturamento = faturamento;
        this.diretor = diretor;
        this.cpfDiretor = cpfDiretor;
    }

    public Animacao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeEpisodios() {
        return quantidadeEpisodios;
    }

    public void setQuantidadeEpisodios(Integer quantidadeEpisodios) {
        this.quantidadeEpisodios = quantidadeEpisodios;
    }

    public LocalDate getDataEstreia() {
        return dataEstreia;
    }

    public void setDataEstreia(LocalDate dataEstreia) {
        this.dataEstreia = dataEstreia;
    }

    public String getCnpjEmpresaResponsavel() {
        return cnpjEmpresaResponsavel;
    }

    public void setCnpjEmpresaResponsavel(String cnpjEmpresaResponsavel) {
        this.cnpjEmpresaResponsavel = cnpjEmpresaResponsavel;
    }

    public Double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(Double faturamento) {
        this.faturamento = faturamento;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getCpfDiretor() {
        return cpfDiretor;
    }

    public void setCpfDiretor(String cpfDiretor) {
        this.cpfDiretor = cpfDiretor;
    }

    @Override
    public String toString() {
        return "Animacao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", quantidadeEpisodios=" + quantidadeEpisodios +
                ", dataEstreia=" + dataEstreia +
                ", cnpjEmpresaResponsavel='" + cnpjEmpresaResponsavel + '\'' +
                ", faturamento=" + faturamento +
                ", diretor='" + diretor + '\'' +
                ", cpfDiretor='" + cpfDiretor + '\'' +
                '}';
    }
}
