package com.refactoring.ch11.step02;

import java.util.function.Function;

public class DiscountCalculator {
//    1. 리팩터링전 코드
//    public int discountForVIP(int price) {
//        return price - 1000;
//    }
//
//    public int discountForEmployee(int price) {
//        return price - 2000;
//    }

    // 2. 하나로 합치기
    public int calculateDiscount(int price, int discountAmount) {
        return price - discountAmount;
    }

    // 3. 람다식으로 확장
    public int calculateDiscount(int price, Function<Integer, Integer> discountStrategy) {
        return discountStrategy.apply(price);
    }
}