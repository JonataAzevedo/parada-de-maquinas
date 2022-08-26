package ubivis.teste.paradademaquinas.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ubivis.teste.paradademaquinas.exception.ResourceConflictDetails;
import ubivis.teste.paradademaquinas.exception.ResourceConflictException;

import java.util.Date;

@ControllerAdvice
public class RestExceptionConflictHandler {

    @ExceptionHandler(ResourceConflictException.class)
    public ResponseEntity<?> handleResourceNotFoundException (ResourceConflictException cException) {
        ResourceConflictDetails cDetails = ResourceConflictDetails.builder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.CONFLICT.value())
                .title("Resource conflict")
                .detail(cException.getMessage())
                .message(cException.getClass().getName()).build();
        return new ResponseEntity<>(cDetails, HttpStatus.CONFLICT);
    }
}
