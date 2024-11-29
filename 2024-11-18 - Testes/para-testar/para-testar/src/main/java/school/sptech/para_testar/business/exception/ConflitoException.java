package school.sptech.para_testar.business.exception;

import org.springframework.http.HttpStatus;

public class ConflitoException extends BusinessException {

    public ConflitoException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
