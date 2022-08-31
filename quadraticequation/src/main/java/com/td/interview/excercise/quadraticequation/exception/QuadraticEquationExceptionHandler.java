package com.td.interview.excercise.quadraticequation.exception;

import com.td.interview.excercise.quadraticequation.entity.QuadraticEquationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class QuadraticEquationExceptionHandler {

    @ExceptionHandler(value = {InvalidRequestException.class})
    public ResponseEntity<Object> handleException(InvalidRequestException excep){
        QuadraticEquationException exception = new QuadraticEquationException(
                excep.getMessage(),
                excep,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("America/New_York"))
        );

        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
