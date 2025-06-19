package com.refactoring.ch11.step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountCalculatorTest {


    @DisplayName("정액 할인 테스트")
    @Test
    void testDiscountByAmount() {
        DiscountCalculator calculator = new DiscountCalculator();
        assertEquals(9000, calculator.discount(10000, 1000));
        assertEquals(8000, calculator.discount(10000, 2000));
    }

    @DisplayName("정률 할인 테스트")
    @Test
    void testDiscountByLambda() {
        DiscountCalculator calc = new DiscountCalculator();
        int result = calc.discount(10000, p -> (int)(p * 0.85)); // 15% 할인
        assertEquals(8500, result);
    }

}