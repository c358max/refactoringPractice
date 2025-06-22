package com.refactoring.ch11.step10;

/**
 * 11.10 명령을 함수로 바꾸기(Replace Command with Function)
 * 리팩터링 전 : 단순 데이터 변환 또는 계산만 수행하는 명령(Command)은
 * 함수(Function)로 바꾸는 것이 코드 가독성과 유지보수성을 높이는데 효과적임.
 * 불필요하게 복잡한 구조(클래스, 필드 등)을 제거하여 간단한 절차로 표현하는 것이 목적임.
 */
public class ChargeCalculator_01 {

    private Customer customer;      // 고객 정보
    private int usage;              // 사용량
    private Provider provider;      // 통신사 정보

    public ChargeCalculator_01(Customer customer, int usage, Provider provider) {
        this.customer = customer;
        this.usage = usage;
        this.provider = provider;
    }

    // 기본요금 계산
    public double getBaseCharge() {
        return customer.getBaseRate() * usage;      // 기본요금 = 기본단가 * 사용량
    }

    // 총 요금 계산
    public double getCharge() {
        return getBaseCharge() + provider.getConnectionCharge();    // 총 요금 = 기본요금 + 통신사 연결 요금
    }

    public static void main(String[] args){
        Customer customer = new Customer(100);       // 예: baseRate = 100
        Provider provider = new Provider(300);       // 예: connectionCharge = 300
        int usage = 50;                              // 예: 사용량

        ChargeCalculator_01 calculator = new ChargeCalculator_01(customer, usage, provider);
        double charge = calculator.getCharge();

        System.out.println("이번 달 요금: " + charge);       // 100 * 50 + 300 = 5300
    }
}