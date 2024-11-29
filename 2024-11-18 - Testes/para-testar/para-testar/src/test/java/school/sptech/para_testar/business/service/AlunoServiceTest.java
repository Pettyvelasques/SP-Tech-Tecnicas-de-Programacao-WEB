package school.sptech.para_testar.business.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.MethodArgumentNotValidException;
import school.sptech.para_testar.business.exception.ConflitoException;
import school.sptech.para_testar.persistence.repository.AlunoRepository;
import school.sptech.para_testar.persistence.entity.Aluno;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlunoServiceTest {

    @InjectMocks
    private AlunoService service;

    @Mock
    private AlunoRepository repository;

    @Test
    @DisplayName("createAluno deve cadastrar com sucesso quando número de matricula e email forem únicos")
    void createAlunoCadastraComSucessoQuandoDadosValidos() {

        var aluno = Aluno.builder()
                .nome("Patrick Velasques")
                .email("patrick.pessanha@sptech.school")
                .dataNascimento(LocalDate.of(1993,5,11))
                .matricula("01232002")
                .build();

        var alunoResposta = Aluno.builder()
                .id(null)
                .nome("Patrick Velasques")
                .email("patrick.pessanha@sptech.school")
                .dataNascimento(LocalDate.of(1993,5,11))
                .matricula("01232002")
                .build();

        Mockito.when(repository.existsByEmailIgnoreCaseOrMatriculaIgnoreCase(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(false);

        Mockito.when(repository.save(Mockito.any(Aluno.class)))
                .thenReturn(aluno);

        Aluno resposta = service.createAluno(aluno);

        assertNotNull(resposta);

        assertEquals(alunoResposta.getId(), resposta.getId());
        assertEquals(alunoResposta.getNome(), resposta.getNome());
        assertEquals(alunoResposta.getEmail(), resposta.getEmail());
        assertEquals(alunoResposta.getDataNascimento(), resposta.getDataNascimento());
        assertEquals(alunoResposta.getMatricula(), resposta.getMatricula());

        Mockito.verify(repository, Mockito.times(1))
                .existsByEmailIgnoreCaseOrMatriculaIgnoreCase(Mockito.anyString(), Mockito.anyString());
        Mockito.verify(repository, Mockito.times(1))
                .save(Mockito.any(Aluno.class));
    }

    @Test
    @DisplayName("createAluno deve setar o id com autoincremento quando cadastrar aluno")
    void createAlunoCadastraIncrementandoId() {

        var aluno = Aluno.builder()
                .nome("Patrick Velasques")
                .email("patrick.pessanha@sptech.school")
                .dataNascimento(LocalDate.of(1993,5,11))
                .matricula("01232002")
                .build();

        var alunoResposta = Aluno.builder()
                .id(1)
                .nome("Patrick Velasques")
                .email("patrick.pessanha@sptech.school")
                .dataNascimento(LocalDate.of(1993,5,11))
                .matricula("01232002")
                .build();

        Mockito.when(repository.existsByEmailIgnoreCaseOrMatriculaIgnoreCase(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(false);

        Mockito.when(repository.save(Mockito.any(Aluno.class)))
                .thenReturn(aluno);

        Aluno resposta = service.createAluno(aluno);

        assertNotNull(resposta.getId());
        assertEquals(alunoResposta.getId(), resposta.getId());
    }

    @Test
    @DisplayName("createAluno deve impedir mandar um id setado na entidade quando cadastrar aluno")
    void createAlunoSobrescreveIdQuandoEnviadoId() {

        var aluno = Aluno.builder()
                .id(10)
                .nome("Patrick Velasques")
                .email("patrick.pessanha@sptech.school")
                .dataNascimento(LocalDate.of(1993,5,11))
                .matricula("01232002")
                .build();

        var alunoResposta = Aluno.builder()
                .id(1)
                .nome("Patrick Velasques")
                .email("patrick.pessanha@sptech.school")
                .dataNascimento(LocalDate.of(1993,5,11))
                .matricula("01232002")
                .build();

        Mockito.when(repository.existsByEmailIgnoreCaseOrMatriculaIgnoreCase(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(false);

        Mockito.when(repository.save(Mockito.any(Aluno.class)))
                .thenReturn(aluno);

        Aluno resposta = service.createAluno(aluno);

        assertNotNull(resposta.getId());
        assertEquals(alunoResposta.getId(), resposta.getId());
    }

    @Test
    @DisplayName("createAluno deve lancar ConflitoException quando matricula ou email existir")
    void createAlunoDeveLancarExceptionQuandoMatriculaOuEmailDuplicado() {

        var aluno = Aluno.builder()
                .id(10)
                .nome("Patrick Velasques")
                .email("patrick.pessanha@sptech.school")
                .dataNascimento(LocalDate.of(1993,5,11))
                .matricula("01232002")
                .build();

        Mockito.when(repository.existsByEmailIgnoreCaseOrMatriculaIgnoreCase(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(true);

        assertThrows(
                ConflitoException.class,
                () -> service.createAluno(aluno)
        );

    }

    @Test
    @DisplayName("createAluno deve lancar MethodArgumentNotValidException quando data de nascimento for futura")
    void createAlunoDeveLancarExceptionQuandoDataNascimentoNaoForPassada() {

        var aluno = Aluno.builder()
                .id(10)
                .nome("Patrick Velasques")
                .email("patrick.pessanha@sptech.school")
                .dataNascimento(LocalDate.of(2025,5,11))
                .matricula("01232002")
                .build();

        Mockito.when(repository.existsByEmailIgnoreCaseOrMatriculaIgnoreCase(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(false);

        assertThrows(
                MethodArgumentNotValidException.class,
                () -> service.createAluno(aluno)
        );

    }

    @Test
    void getAlunoById() {
    }

    @Test
    void deleteAlunoById() {
    }

    @Test
    void getAllAlunos() {
    }
}