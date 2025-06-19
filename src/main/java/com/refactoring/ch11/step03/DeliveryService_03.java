package com.refactoring.ch11.step03;

import java.time.LocalDate;
import java.util.Set;

/**
 * 11.3 플래그 인수 제거하기 (Remove Flag Argument)
 * * deliveryTime 계산 로직 중복 제거
 * * 지역별 배송시간 정보를 상수로 분리
 * * DeliveryType 열거형(enum)으로 배송 타입 정의
 */
public class DeliveryService_03 {

    // 지역별 배송시간 정보
    private static final Set<String> RUSH_ZONE_1 = Set.of("MA", "CT");
    private static final Set<String> RUSH_ZONE_2 = Set.of("NY", "NH");

    private static final Set<String> REGULAR_ZONE_1 = Set.of("MA", "CT", "NY");
    private static final Set<String> REGULAR_ZONE_2 = Set.of("ME", "NH");

    // 계산로직 중복 제거를 위해 DeliveryType 매개변수 사용
    public LocalDate calculateDeliveryDate(Order order, DeliveryType type) {
        int deliveryTime;
        int baseTime = (type == DeliveryType.RUSH) ? 1 : 2;
        String state = order.getDeliveryState();

        if (type == DeliveryType.RUSH) {
            if (RUSH_ZONE_1.contains(state)) deliveryTime = 1;
            else if (RUSH_ZONE_2.contains(state)) deliveryTime = 2;
            else deliveryTime = 3;
        } else {
            if (REGULAR_ZONE_1.contains(state)) deliveryTime = 2;
            else if (REGULAR_ZONE_2.contains(state)) deliveryTime = 3;
            else deliveryTime = 4;
        }

        return order.getPlacedOn().plusDays(baseTime + deliveryTime);
    }

    public static void main(String[] args){
        DeliveryService_03 service = new DeliveryService_03();
        Order order = new Order("MA", LocalDate.now());

        // 호출부 변경
        LocalDate rushDate = service.calculateDeliveryDate(order, DeliveryType.RUSH);
        LocalDate regularDate = service.calculateDeliveryDate(order, DeliveryType.REGULAR);

        System.out.println("빠른배송 날짜: " + rushDate);
        System.out.println("정기배송 날짜: " + regularDate);
    }
}
