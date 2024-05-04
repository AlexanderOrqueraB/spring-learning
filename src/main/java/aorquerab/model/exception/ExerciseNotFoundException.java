package aorquerab.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExerciseNotFoundException extends ResponseStatusException {
    public ExerciseNotFoundException(HttpStatus status, String message) {
        super(status,message);
    }
}
