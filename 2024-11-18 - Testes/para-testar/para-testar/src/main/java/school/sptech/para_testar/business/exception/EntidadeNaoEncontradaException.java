package school.sptech.para_testar.business.exception;

import org.springframework.http.HttpStatus;

public class EntidadeNaoEncontradaException extends BusinessException {

    public EntidadeNaoEncontradaException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}


