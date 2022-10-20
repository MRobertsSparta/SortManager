package com.sparta.mr.controller.exceptions;

public class NullArraySortException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Attempted to sort a null array.";
    }
}
