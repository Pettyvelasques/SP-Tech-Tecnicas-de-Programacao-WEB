package school.sptech.para_testar.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import school.sptech.para_testar.business.exception.ConflitoException;
import school.sptech.para_testar.business.exception.EntidadeNaoEncontradaException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ConflitoException.class)
    public ResponseEntity<ResponseError> handleConflitoException(ConflitoException ex) {
        ResponseError error = new ResponseError(ex.getMessage(), ex.status.value());
        return new ResponseEntity<>(error, ex.status);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<ResponseError> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex) {
        ResponseError error = new ResponseError(ex.getMessage(), ex.status.value());
        return new ResponseEntity<>(error, ex.status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> String.format("'%s' %s", fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        ResponseError error = new ResponseError("Erro de validação de campo.", HttpStatus.BAD_REQUEST.value(), errors);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handleGenericException(Exception ex) {
        ResponseError error = new ResponseError("Erro interno do servidor", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
