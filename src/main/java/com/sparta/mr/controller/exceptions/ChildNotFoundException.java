package com.sparta.mr.controller.exceptions;

public class ChildNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Node could not be found";
    }
}
