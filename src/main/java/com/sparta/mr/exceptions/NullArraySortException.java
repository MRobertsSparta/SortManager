package com.sparta.mr.exceptions;

public class NullArraySortException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Attempted to sort a null array.";
    }
}
