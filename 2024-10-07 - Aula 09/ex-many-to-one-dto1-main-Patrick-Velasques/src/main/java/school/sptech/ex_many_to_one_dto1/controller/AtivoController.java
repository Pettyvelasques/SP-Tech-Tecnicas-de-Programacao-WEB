package school.sptech.ex_many_to_one_dto1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.ex_many_to_one_dto1.dto.ativo.AtivoRequestDto;
import school.sptech.ex_many_to_one_dto1.dto.ativo.AtivoResponseDto;

import java.util.List;

// TODO: TERMINAR A CLASSE
@RestController
@RequestMapping("/ativos")
public class AtivoController {

    public ResponseEntity<AtivoResponseDto> cadastrar(
            AtivoRequestDto ativoRequestDto
    ) {
        return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<List<AtivoResponseDto>> buscarTodos() {
        return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<AtivoResponseDto> buscarPorId(Integer id) {
        return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<Void> deletarPorId(Integer id) {
        return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<List<AtivoResponseDto>> buscarAtivosPorCarteiraNome(String nomeInvestidor) {
        return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<Double> buscarMediaAtivosPorCarteiraNome(String nomeInvestidor) {
        return ResponseEntity.internalServerError().build();
    }
}
