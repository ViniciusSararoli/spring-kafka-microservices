package io.github.icompras.pedidos.model.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationException extends RuntimeException {
    private String message;
    private String field;

    public ValidationException(String field, String message) {
        super(message);
        this.message = message;
        this.field = field;
    }
    
}
