package com.refactoring.ch11.step02;

import java.util.function.Function;

/**
 * 11.2 함수 매개변수화하기 (Parameterize Function)
 */
public class DiscountCalculator {

    public int discount(int price, int discountAmount){
        return price - discountAmount;
    }

    public int discount(int price, Function<Integer, Integer> discountStrategy) {
        return discountStrategy.apply(price);
    }

    public static void main(String[] args){
        DiscountCalculator calculator = new DiscountCalculator();

        int vipPrice = calculator.discount(5000, 1000);
        int employeePrice = calculator.discount(5000, 2000);
        int percent = calculator.discount(10000, p -> (int)(p * 0.9));

        System.out.println("VIP 가격: " + vipPrice); // VIP 가격: 4000
        System.out.println("직원 가격: " + employeePrice); // 직원 가격: 3000
        System.out.println("10% 할인: " + percent); // 직원 가격: 3000
    }
}