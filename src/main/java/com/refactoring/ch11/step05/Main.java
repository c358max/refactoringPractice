package com.refactoring.ch11.step05;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(Arrays.asList(new Item(), new Item(), new Item()));

        // int itemCount = order.getItemCount();
        // int totalPrice = order.calculateTotalPrice(itemCount);

        int totalPrice = order.calculateTotalPrice();

        System.out.println("총 가격: " + totalPrice + "원");
    }
}
