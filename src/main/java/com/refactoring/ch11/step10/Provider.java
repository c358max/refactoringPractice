package com.refactoring.ch11.step10;

public class Provider {
    private double connectionCharge;

    public Provider(double connectionCharge) {
        this.connectionCharge = connectionCharge;
    }

    public double getConnectionCharge() {
        return connectionCharge;
    }

    public void setConnectionCharge(double connectionCharge) {
        this.connectionCharge = connectionCharge;
    }
}
