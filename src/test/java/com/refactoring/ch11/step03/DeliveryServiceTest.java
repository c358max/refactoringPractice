package com.refactoring.ch11.step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryServiceTest {

    private final DeliveryService deliveryService = new DeliveryService();

    @DisplayName("매사추세츠 주(MA)로 빠른배송 테스트")
    @Test
    void testRushDeliveryToMA() {
        Order order = new Order("MA", LocalDate.of(2025, 5, 22));
        LocalDate expectedDate = LocalDate.of(2025, 5, 24); // 1 + 1
        assertEquals(expectedDate, deliveryService.rushDeliveryDate(order));
        assertEquals(expectedDate, deliveryService.calculateDeliveryDate(order, DeliveryType.RUSH));
    }

    @DisplayName("뉴욕 주(NY)로 빠른배송 테스트")
    @Test
    void testRushDeliveryToNY() {
        Order order = new Order("NY", LocalDate.of(2025, 5, 22));
        LocalDate expectedDate = LocalDate.of(2025, 5, 25); // 1 + 2
        assertEquals(expectedDate, deliveryService.rushDeliveryDate(order));
        assertEquals(expectedDate, deliveryService.calculateDeliveryDate(order, DeliveryType.RUSH));
    }

    @DisplayName("그 외 지역(텍사스)으로 빠른배송 테스트")
    @Test
    void testRushDeliveryToOtherState() {
        Order order = new Order("TX", LocalDate.of(2025, 5, 22));
        LocalDate expectedDate = LocalDate.of(2025, 5, 26); // 1 + 3
        assertEquals(expectedDate, deliveryService.rushDeliveryDate(order));
        assertEquals(expectedDate, deliveryService.calculateDeliveryDate(order, DeliveryType.RUSH));
    }

    @DisplayName("매사추세츠 주(MA)로 정기배송 테스트")
    @Test
    void testRegularDeliveryToMA() {
        Order order = new Order("MA", LocalDate.of(2025, 5, 22));
        LocalDate expectedDate = LocalDate.of(2025, 5, 26); // 2 + 2
        assertEquals(expectedDate, deliveryService.regularDeliveryDate(order));
        assertEquals(expectedDate, deliveryService.calculateDeliveryDate(order, DeliveryType.REGULAR));
    }

    @DisplayName("메인 주(ME)로 정기배송 테스트")
    @Test
    void testRegularDeliveryToME() {
        Order order = new Order("ME", LocalDate.of(2025, 5, 22));
        LocalDate expectedDate = LocalDate.of(2025, 5, 27); // 2 + 3
        assertEquals(expectedDate, deliveryService.regularDeliveryDate(order));
        assertEquals(expectedDate, deliveryService.calculateDeliveryDate(order, DeliveryType.REGULAR));
    }

    @DisplayName("그 외 지역(텍사스)으로 정기배송 테스트")
    @Test
    void testRegularDeliveryToOtherState() {
        Order order = new Order("TX", LocalDate.of(2025, 5, 22));
        LocalDate expectedDate = LocalDate.of(2025, 5, 28); // 2 + 4
        assertEquals(expectedDate, deliveryService.regularDeliveryDate(order));
        assertEquals(expectedDate, deliveryService.calculateDeliveryDate(order, DeliveryType.REGULAR));
    }
}