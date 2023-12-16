package com.example.springrestboot.exceptions;

public class UserNotFoundExceprion extends RuntimeException{

    public UserNotFoundExceprion(){
    }

    public UserNotFoundExceprion(String message) {
        super(message);
    }

    public UserNotFoundExceprion(String message, Throwable cause) {
        super(message, cause);
    }
}
