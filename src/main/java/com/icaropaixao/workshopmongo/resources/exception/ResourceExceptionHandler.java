package com.icaropaixao.workshopmongo.resources.exception;


// Manipulador Das Exceptions

import com.icaropaixao.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice // responsavel por tratar possosiveis erros
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class) // anotação para o tratamento funcionar
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error); // retornando o erro


    }
}
