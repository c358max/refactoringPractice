package com.refactoring.ch11.step05;

/**
 * 11.5 매개변수를 질의 함수로 바꾸기 (Replace Parameter with Query)
 * * 호출하는 부분마다 basePrice와 discountLevel을 계산하여 매개변수로 전달하는 대신,
 * * getBasePrice()와 getDiscountLevel() 메서드를 통해 한곳에서만 계산하도록 변경
 * * 이렇게 하면 코드의 중복을 줄이고, 각 메서드가 자신의 책임에 집중할 수 있게 되어
 * * 코드의 가독성과 유지보수성이 향상됨.
 */
public class Order_03 {
    private int quantity;
    private int itemPrice;

    public Order_03(int quantity, int itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    // 수량 × 단가 → basePrice 계산
    public int getBasePrice() {
        return quantity * itemPrice; // 수량 × 단가
    }

    // 할인 등급 계산
    public int getDiscountLevel() {
        return DiscountPolicy.getDiscountLevel(quantity);
    }

    // 할인 가격 계산
    public int calculateDiscountPrice() {
        return DiscountPolicy.applyDiscount(getBasePrice(), getDiscountLevel());
    }

    // 최종 가격 계산
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