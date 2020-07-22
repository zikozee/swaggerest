package com.zikozee.swaggerest.controller;


import com.zikozee.swaggerest.exception.DateException;
import com.zikozee.swaggerest.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings({"unchecked", "rawtypes"})
@ControllerAdvice
public class SuperController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DateException.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(DateException ex) {
        ErrorResponse error = new ErrorResponse("Client Error", ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
