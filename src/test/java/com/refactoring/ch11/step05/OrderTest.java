package com.refactoring.ch11.step05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void testCalculateTotalPriceWithThreeItems() {
        Order order = new Order(Arrays.asList(new Item(), new Item(), new Item()));
        assertEquals(3000, order.calculateTotalPrice());
    }

    @Test
    void testCalculateTotalPriceWithOneItem() {
        Order order = new Order(Collections.singletonList(new Item()));
        assertEquals(1000, order.calculateTotalPrice());
    }

    @Test
    void testCalculateTotalPriceWithZeroItems() {
        Order order = new Order(Collections.emptyList());
        assertEquals(0, order.calculateTotalPrice());
    }

    @Test
    void testGetItemCount() {
        Order order = new Order(Arrays.asList(new Item(), new Item()));
        assertEquals(2, order.getItemCount());
    }
}