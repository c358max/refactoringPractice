package com.refactoring.ch11.step05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void testFinalPrice_DiscountLevel1_Exactly100() {
        Order order = new Order(100, 1000); // 100개 → discountLevel = 1
        double expected = 100 * 1000 * 0.95;
        assertEquals(expected, order.getFinalPrice(), 0.001);
    }

    @Test
    void testFinalPrice_DiscountLevel2_Over100() {
        Order order = new Order(150, 1000); // 150개 → discountLevel = 2
        double expected = 150 * 1000 * 0.9;
        assertEquals(expected, order.getFinalPrice(), 0.001);
    }

    @Test
    void testFinalPrice_DiscountLevel1_Under100() {
        Order order = new Order(50, 1000); // 50개 → discountLevel = 1
        double expected = 50 * 1000 * 0.95;
        assertEquals(expected, order.getFinalPrice(), 0.001);
    }

    @Test
    void testFinalPrice_ZeroQuantity() {
        Order order = new Order(0, 1000); // 0개 → 가격은 0
        assertEquals(0, order.getFinalPrice(), 0.001);
    }
}