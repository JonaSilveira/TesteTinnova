package com.teste.tinnova.testetinnova.handle;

import com.teste.tinnova.testetinnova.exceptions.BadRequestException;
import com.teste.tinnova.testetinnova.exceptions.BadRequestExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class BadRequestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException badRequestException){
        return new ResponseEntity<BadRequestExceptionDetails>(
                (BadRequestExceptionDetails) BadRequestExceptionDetails.builder()
                .details(badRequestException.getMessage())
                .title("Bad Request Exception")
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(badRequestException.getClass().getName())
                .build(),HttpStatus.BAD_REQUEST);

    }

}
