package com.refactoring.ch11.step10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChargeCalculatorTest {

    @DisplayName("정상 요금 계산 테스트")
    @Test
    void testCalculateCharge_NormalCase() {
        Customer customer = new Customer(100);
        Provider provider = new Provider(300);
        int usage = 50;

        double expectedCharge = 100 * 50 + 300;    // 5000 + 300 = 5300
        double actualCharge = ChargeCalculator.calculate(customer, usage, provider);

        assertEquals(expectedCharge, actualCharge, 0.001);
    }

    @DisplayName("사용량이 0인 경우 요금 계산 테스트")
    @Test
    void testCalculateCharge_ZeroUsage() {
        Customer customer = new Customer(100);
        Provider provider = new Provider(300);
        int usage = 0;

        double expectedCharge = 0 + 300;
        double actualCharge = ChargeCalculator.calculate(customer, usage, provider);

        assertEquals(expectedCharge, actualCharge, 0.001);
    }

    @DisplayName("연결 요금이 0인 경우 테스트")
    @Test
    void testCalculateCharge_ZeroConnectionCharge() {
        Customer customer = new Customer(120);
        Provider provider = new Provider(0);
        int usage = 10;

        double expectedCharge = 120 * 10;
        double actualCharge = ChargeCalculator.calculate(customer, usage, provider);

        assertEquals(expectedCharge, actualCharge, 0.001);
    }

    @DisplayName("기본 단가가 0인 경우 테스트")
    @Test
    void testCalculateCharge_ZeroBaseRate() {
        Customer customer = new Customer(0);
        Provider provider = new Provider(500);
        int usage = 100;

        double expectedCharge = 0 + 500;
        double actualCharge = ChargeCalculator.calculate(customer, usage, provider);

        assertEquals(expectedCharge, actualCharge, 0.001);
    }
}