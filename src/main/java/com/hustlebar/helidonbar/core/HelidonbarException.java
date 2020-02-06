package com.hustlebar.helidonbar.core;

public class HelidonbarException extends Exception {
    String code;

    public HelidonbarException() { super(); }

    public HelidonbarException(String message) {
        super(message);
    }

    public HelidonbarException(String code, String message) {
        this(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
