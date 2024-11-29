package school.sptech.para_testar.presentation.exception;

import lombok.Data;

import java.util.List;

@Data
public class ResponseError {
    private String message;
    private int status;
    private String timestamp;
    private List<String> errors;

    public ResponseError(String message, int status, List<String> errors) {
        this.message = message;
        this.status = status;
        this.timestamp = java.time.LocalDateTime.now().toString();
        this.errors = errors;
    }

    public ResponseError(String message, int status) {
        this(message, status, null);
    }
}
