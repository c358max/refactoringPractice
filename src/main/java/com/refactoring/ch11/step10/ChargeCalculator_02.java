package com.refactoring.ch11.step10;

/**
 * 11.10 명령을 함수로 바꾸기(Replace Command with Function)
 * 기존 getBaseCharge(), getCharge() 메서드를 제거하고 calculate 메서드로 통합
 * 호출부에서 객체 생성 없이 calculate 메서드 호출
 */
public class ChargeCalculator_02 {

    private Customer customer;      // 고객 정보
    private int usage;              // 사용량
    private Provider provider;      // 통신사 정보

    public ChargeCalculator_02(Customer customer, int usage, Provider provider) {
        this.customer = customer;
        this.usage = usage;
        this.provider = provider;
    }

    // 총 요금 계산(단순 메서드로 정리)
    public static double calculate(Customer customer, int usage, Provider provider) {
        double baseCharge = customer.getBaseRate() * usage; // 기본요금 = 기본단가 * 사용량
        return baseCharge + provider.getConnectionCharge(); // 총 요금 = 기본요금 + 통신사 연결 요금
    }

    public static void main(String[] args){
        Customer customer = new Customer(100);       // 예: baseRate = 100
        Provider provider = new Provider(300);       // 예: connectionCharge = 300
        int usage = 50;                              // 예: 사용량

        // ChargeCalculator_02 객체 생성 없이 calculate 메서드 호출
        double charge = ChargeCalculator_02.calculate(customer, usage, provider);

        System.out.println("이번 달 요금: " + charge);       // 100 * 50 + 300 = 5300
    }
}