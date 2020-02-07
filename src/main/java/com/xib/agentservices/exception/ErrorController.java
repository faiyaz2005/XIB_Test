package com.xib.agentservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleCustomError(
            CustomException ex) {
        return new ExceptionResponse(ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ExceptionResponse handleCustomError(
            EntityNotFoundException ex) {
        return new ExceptionResponse(ex.getMessage());
    }

}
