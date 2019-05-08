package com.skillup.automation;

public class Calculator {

    public int divide(int a, int b) {
        int result;
        try {
            result = a / b;
        } catch (ArithmeticException e) {
            throw e;
        }


        return result;
    }
}
