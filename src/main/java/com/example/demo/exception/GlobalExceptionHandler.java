package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.dto.ExceptionDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryAlreadyExistException.class)
    public ResponseEntity<?> handleCategoryAlreadyExistException(CategoryAlreadyExistException e,WebRequest request){
        ExceptionDTO exceptionDTO = new ExceptionDTO(
            request.getDescription(false),
            HttpStatus.CONFLICT,
            e.getMessage(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDTO);
    }

    

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<?> handleCategoryNotFoundException(
        CategoryNotFoundException e,
        WebRequest request
        ){
        ExceptionDTO exceptionDTO = new ExceptionDTO(
            request.getDescription(false),
            HttpStatus.CONFLICT,
            e.getMessage(),
            LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException e,WebRequest request){
        ExceptionDTO exceptionDTO = new ExceptionDTO(
            request.getDescription(false),
            HttpStatus.CONFLICT,
            e.getMessage(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception e,WebRequest request){
        ExceptionDTO exceptionDTO = new ExceptionDTO(
            request.getDescription(false),
            HttpStatus.INTERNAL_SERVER_ERROR,
            e.getMessage(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionDTO);
    }
}
