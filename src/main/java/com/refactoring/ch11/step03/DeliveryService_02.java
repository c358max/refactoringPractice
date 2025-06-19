package com.refactoring.ch11.step03;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * 11.3 플래그 인수 제거하기 (Remove Flag Argument)
 * * isRush 플래그 인수를 제거후 두개의 메서드로 분리(빠른배송, 정기배송)
 * 호출 시 어떤 배송 방식을 선택하는지 명확하게 알 수 있음
 */
public class DeliveryService_02 {

    // 빠른배송
    public LocalDate rushDeliveryDate(Order order) {
        int deliveryTime;

        if (order.getDeliveryState().equals("MA") || order.getDeliveryState().equals("CT")) {
            deliveryTime = 1;
        } else if (order.getDeliveryState().equals("NY") || order.getDeliveryState().equals("NH")) {
            deliveryTime = 2;
        } else {
            deliveryTime = 3;
        }
        return order.getPlacedOn().plusDays(1 + deliveryTime);
    }

    // 정기배송
    public LocalDate regularDeliveryDate(Order order) {
        int deliveryTime;

        if (order.getDeliveryState().equals("MA") || order.getDeliveryState().equals("CT") || order.getDeliveryState().equals("NY")) {
            deliveryTime = 2;
        } else if (order.getDeliveryState().equals("ME") || order.getDeliveryState().equals("NH")) {
            deliveryTime = 3;
        } else {
            deliveryTime = 4;
        }
        return order.getPlacedOn().plusDays(2 + deliveryTime);
    }

    public static void main(String[] args){
        DeliveryService_02 service = new DeliveryService_02();
        Order order = new Order("MA", LocalDate.now());

        LocalDate rushDate = service.rushDeliveryDate(order);
        LocalDate regularDate = service.regularDeliveryDate(order);

        System.out.println("빠른배송 날짜: " + rushDate);
        System.out.println("정기배송 날짜: " + regularDate);
    }
}
