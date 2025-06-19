package com.refactoring.ch11.step03;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * 11.3 플래그 인수 제거하기 (Remove Flag Argument)
 * 리팩터링 전 : 조건에 따라 두 가지 다른 동작을 수행하는 함수에서 boolean 플래그 인수 사용
 * isRush만 봐서는 어떤 동작을 하는지 명확하지 않음
 * 플래그 인수(flag argument)를 제거하여 명확성과 테스트 용이성을 높이는게 목적
 */
public class DeliveryService_01 {

    public LocalDate deliveryDate(Order anOrder, boolean isRush) {
        int deliveryTime;

        if (isRush) {
            if (Arrays.asList("MA", "CT").contains(anOrder.getDeliveryState())) {
                deliveryTime = 1;
            } else if (Arrays.asList("NY", "NH").contains(anOrder.getDeliveryState())) {
                deliveryTime = 2;
            } else {
                deliveryTime = 3;
            }
            return anOrder.getPlacedOn().plusDays(1 + deliveryTime);
        } else {
            if (Arrays.asList("MA", "CT", "NY").contains(anOrder.getDeliveryState())) {
                deliveryTime = 2;
            } else if (Arrays.asList("ME", "NH").contains(anOrder.getDeliveryState())) {
                deliveryTime = 3;
            } else {
                deliveryTime = 4;
            }
            return anOrder.getPlacedOn().plusDays(2 + deliveryTime);
        }
    }

    public static void main(String[] args) {
        DeliveryService_01 service = new DeliveryService_01();
        Order order = new Order("MA", LocalDate.now());

        LocalDate rushDate = service.deliveryDate(order, true);
        LocalDate regularDate = service.deliveryDate(order, false);

        System.out.println("빠른배송 날짜: " + rushDate);
        System.out.println("정기배송 날짜: " + regularDate);
    }
}
