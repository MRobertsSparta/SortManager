package com.sparta.mr.exceptions;

public class NoRootNodeException extends RuntimeException{
    @Override
    public String getMessage() {
        return "No Root Node Found";
    }
}
