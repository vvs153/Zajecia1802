package com.sda.zadanie1802.exception;

public class IllegalValueException extends RuntimeException{
    public IllegalValueException(String nazwa){
        super("niepoprawna wartosc pola: " + nazwa);
    }
}
