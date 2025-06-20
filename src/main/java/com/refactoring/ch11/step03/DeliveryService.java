package com.refactoring.ch11.step03;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

/**
 * 11.3 플래그 인수 제거하기 (Remove Flag Argument)
 */
public class DeliveryService {

    private static final Set<String> RUSH_ZONE_1 = Set.of("MA", "CT");
    private static final Set<String> RUSH_ZONE_2 = Set.of("NY", "NH");

    private static final Set<String> REGULAR_ZONE_1 = Set.of("MA", "CT", "NY");
    private static final Set<String> REGULAR_ZONE_2 = Set.of("ME", "NH");

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

    // 아래 메서드 삭제
    public LocalDate rushDeliveryDate(Order anOrder) {
        int deliveryTime;

        if (Arrays.asList("MA", "CT").contains(anOrder.getDeliveryState())) {
            deliveryTime = 1;
        } else if (Arrays.asList("NY", "NH").contains(anOrder.getDeliveryState())) {
            deliveryTime = 2;
        } else {
            deliveryTime = 3;
        }

        return anOrder.getPlacedOn().plusDays(1 + deliveryTime);
    }

    // 아래 메서드 삭제
    public LocalDate regularDeliveryDate(Order anOrder) {
        int deliveryTime;

        if (Arrays.asList("MA", "CT", "NY").contains(anOrder.getDeliveryState())) {
            deliveryTime = 2;
        } else if (Arrays.asList("ME", "NH").contains(anOrder.getDeliveryState())) {
            deliveryTime = 3;
        } else {
            deliveryTime = 4;
        }

        return anOrder.getPlacedOn().plusDays(2 + deliveryTime);
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
