package com.refactoring.ch11.step05;

import java.util.List;

/**
 * 11.5 매개변수를 질의 함수로 바꾸기 (Replace Parameter with Query)
 */
public class Order {
    private int quantity;
    private int itemPrice;

    public Order(int quantity, int itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public int getBasePrice() {
        return quantity * itemPrice; // 수량 × 단가
    }

    public int getDiscountLevel() {
        return DiscountPolicy.getDiscountLevel(quantity);
    }

    public int calculateDiscountPrice() {
        return DiscountPolicy.applyDiscount(getBasePrice(), getDiscountLevel());
    }

    public int finalPrice() {
        return calculateDiscountPrice();
    }

    public static void main(String[] args) {
        Order_03 smallOrder = new Order_03(50, 100);   // 수량 50, 단가 100
        Order_03 largeOrder = new Order_03(150, 100);  // 수량 150, 단가 100

        System.out.println("[소량 주문]");
        System.out.println("기본 가격: " + smallOrder.getBasePrice());
        System.out.println("할인 등급: " + smallOrder.getDiscountLevel());
        System.out.println("최종 가격: " + smallOrder.finalPrice());

        System.out.println("\n[대량 주문]");
        System.out.println("기본 가격: " + largeOrder.getBasePrice());
        System.out.println("할인 등급: " + largeOrder.getDiscountLevel());
        System.out.println("최종 가격: " + largeOrder.finalPrice());
    }
}