package com.refactoring.ch11.step10;

public class Main {
    public static void main(String[] args) {
        // 고객과 공급자 객체 생성
        Customer customer = new Customer(0.12);      // 단가: 0.12
        Provider provider = new Provider(5.0);       // 고정 요금: 5.0
        int usage = 100;                             // 사용량: 100

        // 리팩터링 후: 명령 객체 대신 정적 함수로 계산
        double monthCharge = ChargeCalculator.calculateCharge(customer, usage, provider);

        System.out.println("이번 달 요금: " + monthCharge);  // 출력: 17.0
    }
}
