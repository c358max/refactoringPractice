package com.refactoring.ch11.step12;

public class NoShippingRulesException extends RuntimeException {
    public NoShippingRulesException(String message) {
        super(message);
    }
}
