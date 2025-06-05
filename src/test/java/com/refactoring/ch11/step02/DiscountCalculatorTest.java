package com.refactoring.ch11.step02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountCalculatorTest {


    @Test
    void testDiscountByAmount() {
        DiscountCalculator calculator = new DiscountCalculator();
        assertEquals(9000, calculator.calculateDiscount(10000, 1000));
        assertEquals(8000, calculator.calculateDiscount(10000, 2000));
    }

    @Test
    void testDiscountByLambda() {
        DiscountCalculator calc = new DiscountCalculator();
        int result = calc.calculateDiscount(10000, p -> (int)(p * 0.85)); // 15% 할인
        assertEquals(8500, result);
    }

}