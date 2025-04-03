package com.icaropaixao.workshopmongo.resources.exception;

public class ResourceExceptionHandler extends RuntimeException {
    public ResourceExceptionHandler(String message) {
        super(message);
    }
}
