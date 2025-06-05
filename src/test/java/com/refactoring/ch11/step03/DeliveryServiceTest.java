package com.refactoring.ch11.step03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryServiceTest {

    private final DeliveryService deliveryService = new DeliveryService();

    @Test
    void testRushDeliveryToMA() {
        Order order = new Order("MA", LocalDate.of(2025, 5, 22));
        LocalDate expectedDate = LocalDate.of(2025, 5, 24); // 1 + 1
        assertEquals(expectedDate, deliveryService.rushDeliveryDate(order));
    }

    @Test
    void testRushDeliveryToNY() {
        Order order = new Order("NY", LocalDate.of(2025, 5, 22));
        LocalDate expectedDate = LocalDate.of(2025, 5, 25); // 1 + 2
        assertEquals(expectedDate, deliveryService.rushDeliveryDate(order));
    }

    @Test
    void testRushDeliveryToOtherState() {
        Order order = new Order("TX", LocalDate.of(2025, 5, 22));
        LocalDate expectedDate = LocalDate.of(2025, 5, 26); // 1 + 3
        assertEquals(expectedDate, deliveryService.rushDeliveryDate(order));
    }

    @Test
    void testRegularDeliveryToMA() {
        Order order = new Order("MA", LocalDate.of(2025, 5, 22));
        LocalDate expectedDate = LocalDate.of(2025, 5, 26); // 2 + 2
        assertEquals(expectedDate, deliveryService.regularDeliveryDate(order));
    }

    @Test
    void testRegularDeliveryToME() {
        Order order = new Order("ME", LocalDate.of(2025, 5, 22));
        LocalDate expectedDate = LocalDate.of(2025, 5, 27); // 2 + 3
        assertEquals(expectedDate, deliveryService.regularDeliveryDate(order));
    }

    @Test
    void testRegularDeliveryToOtherState() {
        Order order = new Order("TX", LocalDate.of(2025, 5, 22));
        LocalDate expectedDate = LocalDate.of(2025, 5, 28); // 2 + 4
        assertEquals(expectedDate, deliveryService.regularDeliveryDate(order));
    }
}