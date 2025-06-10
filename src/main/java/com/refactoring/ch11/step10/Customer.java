package com.refactoring.ch11.step10;

public class Customer {
    private double baseRate;

    public Customer(double baseRate) {
        this.baseRate = baseRate;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }
}
