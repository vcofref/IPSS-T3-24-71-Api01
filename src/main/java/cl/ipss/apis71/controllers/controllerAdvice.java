package cl.ipss.apis71.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cl.ipss.apis71.responses.VideojuegoResponse;

@RestControllerAdvice
public class controllerAdvice {

    @ExceptionHandler(value=RuntimeException.class)
    public ResponseEntity<Object> RuntimeExceptionHeadler(RuntimeException ex){
        VideojuegoResponse videojuegoResponse = new VideojuegoResponse();
        videojuegoResponse.setStatus(450);
        videojuegoResponse.setMessage(ex.getMessage());

        return ResponseEntity.badRequest()
        .body(videojuegoResponse);
    }

}
