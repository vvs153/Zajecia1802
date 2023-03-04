package com.sda.zadanie1802.controller;

import com.sda.zadanie1802.exception.IllegalValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({IllegalValueException.class})
    public ResponseEntity<String> handle(IllegalValueException ive, WebRequest request){
        return ResponseEntity
                .badRequest()
                .body("kontrolwana sytuacja, niepoprawna wartosc" + ive.getMessage());
    }
}
