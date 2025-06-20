package com.refactoring.ch11.step05;

/**
 * 11.5 매개변수를 질의 함수로 바꾸기 (Replace Parameter with Query)
 * Order 클래스의 할인 정책을 관리하는 DiscountPolicy 클래스로 분리
 * 계산 로직을 별도의 클래스에서 관리하여 Order 클래스의 책임을 분리
 */
public class DiscountPolicy {
    public static int getDiscountLevel(int quantity) {
        return (quantity > 100) ? 2 : 1;
    }

    public static int applyDiscount(int basePrice, int discountLevel) {
        return switch (discountLevel) {
            case 2 -> basePrice * 90 / 100;
            case 1 -> basePrice * 95 / 100;
            default -> basePrice;
        };
    }
}
