package com.catsapi.exceptions;

public class CatAlreadyExistException extends Exception{
    public CatAlreadyExistException(String message) {
        super(message);
    }
}
