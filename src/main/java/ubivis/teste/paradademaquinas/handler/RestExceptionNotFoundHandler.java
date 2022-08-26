package ubivis.teste.paradademaquinas.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ubivis.teste.paradademaquinas.exception.ResourceNotFoundDetails;
import ubivis.teste.paradademaquinas.exception.ResourceNotFoundException;

import java.util.Date;

@ControllerAdvice
public class RestExceptionNotFoundHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException (ResourceNotFoundException rfnException){
        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.builder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(rfnException.getMessage())
                .message(rfnException.getClass().getName()).build();
        return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
    }
}
