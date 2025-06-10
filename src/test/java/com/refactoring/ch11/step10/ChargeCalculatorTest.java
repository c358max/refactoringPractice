package com.refactoring.ch11.step10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChargeCalculatorTest {
    @Test
    void 기본_요금_계산_정상작동() {
        Customer customer = new Customer(0.15);
        Provider provider = new Provider(10.0);
        int usage = 200;

//        ChargeCalculator calculator = new ChargeCalculator(customer, usage, provider);
//        double result = calculator.getCharge();
        double result = ChargeCalculator.calculateCharge(customer, usage, provider);

        assertEquals(40.0, result);
    }

    @Test
    void 사용량이_0이면_기본요금만_부과() {
        Customer customer = new Customer(0.25);
        Provider provider = new Provider(8.0);
        int usage = 0;

//        ChargeCalculator calculator = new ChargeCalculator(customer, usage, provider);
//        double result = calculator.getCharge();
        double result = ChargeCalculator.calculateCharge(customer, usage, provider);


        assertEquals(8.0, result);
    }

    @Test
    void 고정요금이_0이면_순수단가만_계산() {
        Customer customer = new Customer(0.1);
        Provider provider = new Provider(0.0);
        int usage = 150;

//        ChargeCalculator calculator = new ChargeCalculator(customer, usage, provider);
//        double result = calculator.getCharge();
        double result = ChargeCalculator.calculateCharge(customer, usage, provider);

        assertEquals(15.0, result);
    }

    @Test
    void 마이너스_사용량_테스트() {
        Customer customer = new Customer(0.2);
        Provider provider = new Provider(5.0);
        int usage = -50;

//        ChargeCalculator calculator = new ChargeCalculator(customer, usage, provider);
//        double result = calculator.getCharge();
        double result = ChargeCalculator.calculateCharge(customer, usage, provider);

        assertEquals(-5.0, result);
    }
}