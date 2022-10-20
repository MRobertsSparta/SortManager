package com.sparta.mr.controller.exceptions;

public class InvalidInputException extends Exception {

    @Override
    public String getMessage() {
        return "The given input was invalid";
    }
}
