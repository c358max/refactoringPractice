package com.refactoring.ch11.step02;

/**
 * 11.2 함수 매개변수화하기 (Parameterize Function)
 * 리팩터링 전 : 서로 유사하지만 다른 상수값(또는 조건)만 다른 여러 함수를 하나의 함수로 합치기
 * 중복을 줄이고 코드의 재사용성과 유지보수성을 향상시키는게 목적
 */
public class DiscountCalculator_01 {

    public int discountForVIP(int price) {
        return price - 1000;
    }

    public int discountForEmployee(int price) {
        return price - 2000;
    }

    public static void main(String[] args){
        DiscountCalculator_01 calculator = new DiscountCalculator_01();

        int vipPrice = calculator.discountForVIP(5000);
        int employeePrice = calculator.discountForEmployee(5000);

        System.out.println("VIP 가격: " + vipPrice); // VIP 가격: 4000
        System.out.println("직원 가격: " + employeePrice); // 직원 가격: 3000
    }
}