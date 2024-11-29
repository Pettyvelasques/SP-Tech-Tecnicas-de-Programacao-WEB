package school.sptech.para_testar.business.exception;

import org.springframework.http.HttpStatus;

public abstract class BusinessException extends RuntimeException {
    public final HttpStatus status;

    public BusinessException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
