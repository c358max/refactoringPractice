package com.refactoring.ch11.step10;

/**
 * 11.10 명령을 함수로 바꾸기(Replace Command with Function)
 */
public class ChargeCalculator {

    private Customer customer;
    private int usage;
    private Provider provider;

    public ChargeCalculator(Customer customer, int usage, Provider provider) {
        this.customer = customer;
        this.usage = usage;
        this.provider = provider;
    }

    public static double calculate(Customer customer, int usage, Provider provider) {
        double baseCharge = customer.getBaseRate() * usage;
        return baseCharge + provider.getConnectionCharge();
    }

    public static void main(String[] args){
        Customer customer = new Customer(100);
        Provider provider = new Provider(300);
        int usage = 50;

        double charge = ChargeCalculator_02.calculate(customer, usage, provider);

        System.out.println("이번 달 요금: " + charge);       // 100 * 50 + 300 = 5300
    }
}