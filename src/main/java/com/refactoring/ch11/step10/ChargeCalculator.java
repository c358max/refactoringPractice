package com.refactoring.ch11.step10;

public class ChargeCalculator {
    private Customer customer;
    private int usage;
    private Provider provider;

    public ChargeCalculator(Customer customer, int usage, Provider provider) {
        this.customer = customer;
        this.usage = usage;
        this.provider = provider;
    }

    public double getBaseCharge() {
        return customer.getBaseRate() * usage;
    }

    public double getCharge() {
        return getBaseCharge() + provider.getConnectionCharge();
    }

    // 리팩터링 후
    public static double calculateCharge(Customer customer, int usage, Provider provider) {
        double baseCharge = customer.getBaseRate() * usage;
        return baseCharge + provider.getConnectionCharge();
    }
}