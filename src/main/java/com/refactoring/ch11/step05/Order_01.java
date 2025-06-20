package com.refactoring.ch11.step05;

/**
 * 11.5 매개변수를 질의 함수로 바꾸기 (Replace Parameter with Query)
 * 리팩터링 전 : discountPrice() 함수에 basePrice와 discountLevel 매개변수 전달
 * 호출자가 알고 있는 값을 매개변수로 넘기는 대신, 객체 안에서 자체 질의를 통해 값을 계산하도록 변경
 * 캡슐화를 강화하고 중복을 제거하여 코드의 의도를 명확히 표현하는게 목적
 */
public class Order_01 {
    private int quantity;
    private int itemPrice;

    public Order_01(int quantity, int itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public int calculateDiscountPrice(int basePrice, int discountLevel) {
        if (discountLevel == 2) return basePrice * 90 / 100;
        return basePrice * 95 / 100;
    }

    public int finalPrice() {
        int basePrice = quantity * itemPrice;
        int discountLevel = (quantity > 100) ? 2 : 1;
        return calculateDiscountPrice(basePrice, discountLevel);
    }

    public static void main(String[] args) {
        Order_01 smallOrder = new Order_01(50, 100);   // 수량 50, 단가 100
        Order_01 largeOrder = new Order_01(150, 100);  // 수량 150, 단가 100

        // 수량 × 단가 → basePrice 계산
        int basePriceSmall = 50 * 100;
        int discountLevelSmall = (50 > 100) ? 2 : 1;
        int finalPriceSmall = smallOrder.calculateDiscountPrice(basePriceSmall, discountLevelSmall);

        int basePriceLarge = 150 * 100;
        int discountLevelLarge = (150 > 100) ? 2 : 1;
        int finalPriceLarge = largeOrder.calculateDiscountPrice(basePriceLarge, discountLevelLarge);

        System.out.println("[소량 주문]");
        System.out.println("기본 가격: " + basePriceSmall);
        System.out.println("할인 등급: " + discountLevelSmall);
        System.out.println("최종 가격: " + finalPriceSmall);

        System.out.println("\n[대량 주문]");
        System.out.println("기본 가격: " + basePriceLarge);
        System.out.println("할인 등급: " + discountLevelLarge);
        System.out.println("최종 가격: " + finalPriceLarge);
    }
}