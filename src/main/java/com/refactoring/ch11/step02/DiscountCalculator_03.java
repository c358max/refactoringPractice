package com.refactoring.ch11.step02;

import java.util.function.Function;

/**
 * 11.2 함수 매개변수화하기 (Parameterize Function)
 * * 사용하지 않는 메서드는 삭제처리
 * * 추가로 단순 정수 할인에서 람다식으로 할인 전략을 확장
 */
public class DiscountCalculator_03 {

    // 정수 할인 금액을 적용하는 메서드
    public int discount(int price, int discountAmount){
        return price - discountAmount;
    }

    // 할인 금액만 처리하는게 아니라 동적으로 할인방식 적용위한 람다식 사용
    public int discount(int price, Function<Integer, Integer> discountStrategy) {
        return discountStrategy.apply(price);
    }

    public static void main(String[] args){
        DiscountCalculator_03 calculator = new DiscountCalculator_03();

        int vipPrice = calculator.discount(5000, 1000);
        int employeePrice = calculator.discount(5000, 2000);
        int percent = calculator.discount(10000, p -> (int)(p * 0.9));

        System.out.println("VIP 가격: " + vipPrice); // VIP 가격: 4000
        System.out.println("직원 가격: " + employeePrice); // 직원 가격: 3000
        System.out.println("10% 할인: " + percent); // 직원 가격: 3000
    }
}