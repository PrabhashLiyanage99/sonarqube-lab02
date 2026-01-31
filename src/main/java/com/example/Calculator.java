package com.example;

public class Calculator {

    public int calculate(int a, int b, String op) {
        if (op == null) {
            return 0;
        }

        // Using modern Switch Expression (fixes java:S6208)
        return switch (op) {
            case "add" -> a + b;
            case "sub" -> a - b;
            case "mul" -> a * b;
            case "div" -> (b == 0) ? 0 : a / b;
            case "mod" -> a % b;
            case "pow" -> (int) Math.pow(a, b);
            default    -> 0;
        };
    }
}