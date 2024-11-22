package com.es.seguridadsession.utils;

public class ExceptionUtil {
    private String message;
    private Throwable cause;

    public ExceptionUtil(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }

    public ExceptionUtil(String message, String cause) {

    }
}
