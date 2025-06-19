package com.refactoring.ch11.step02;

/**
 * 11.2 함수 매개변수화하기 (Parameterize Function)
 * * 매개변수로 할인 금액 추출
 * * discountForVIP, discountForEmployee 메서드를 discount 메서드로 통합
 * * 기존 discountForVIP, discountForEmployee 호출부 수정 -> discount 메서드 호출로 변경
 */
public class DiscountCalculator_02 {

    public int discountForVIP(int price) {
        return price - 1000;
    }

    public int discountForEmployee(int price) {
        return price - 2000;
    }

    // 1. discountForVIP, discountForEmployee 함수 통합
    public int discount(int price, int discountAmount){
        return price - discountAmount;
    }

    public static void main(String[] args){
        DiscountCalculator_02 calculator = new DiscountCalculator_02();

        // 2. discountForVIP, discountForEmployee 호출부 수정
        int vipPrice = calculator.discount(5000, 1000);
        int employeePrice = calculator.discount(5000, 2000);

        System.out.println("VIP 가격: " + vipPrice); // VIP 가격: 4000
        System.out.println("직원 가격: " + employeePrice); // 직원 가격: 3000
    }
}