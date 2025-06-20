package com.refactoring.ch11.step05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @DisplayName("100개 주문 시 할인 등급 1 적용 → 5% 할인된 가격 반환")
    @Test
    void testFinalPrice_DiscountLevel1_Exactly100() {
        Order order = new Order(100, 1000); // 100개 → discountLevel = 1
        double expected = 100 * 1000 * 0.95;
        assertEquals(expected, order.calculateDiscountPrice(), 0.001);
    }

    @DisplayName("100개 초과 주문 시 할인 등급 2 적용 → 10% 할인된 가격 반환")
    @Test
    void testFinalPrice_DiscountLevel2_Over100() {
        Order order = new Order(150, 1000); // 150개 → discountLevel = 2
        double expected = 150 * 1000 * 0.9;
        assertEquals(expected, order.calculateDiscountPrice(), 0.001);
    }

    @DisplayName("100개 미만 주문 시 할인 등급 1 적용 → 5% 할인된 가격 반환")
    @Test
    void testFinalPrice_DiscountLevel1_Under100() {
        Order order = new Order(50, 1000); // 50개 → discountLevel = 1
        double expected = 50 * 1000 * 0.95;
        assertEquals(expected, order.calculateDiscountPrice(), 0.001);
    }

    @DisplayName("수량이 0일 때 → 최종 가격은 0")
    @Test
    void testFinalPrice_ZeroQuantity() {
        Order order = new Order(0, 1000); // 0개 → 가격은 0
        assertEquals(0, order.calculateDiscountPrice(), 0.001);
    }
}