package com.hustlebar.helidonbar.restclient;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Calculator {
    public long add(long num1, long num2) {
        return num1 + num2;
    }

    public long subtract(long num1, long num2) {
        return num1 - num2;
    }
}
