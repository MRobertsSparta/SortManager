package com.sparta.mr.exceptions;

public class InvalidInputException extends Exception {

    @Override
    public String getMessage() {
        return "The given input was invalid";
    }
}
