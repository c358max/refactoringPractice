package com.refactoring.ch11.step03;

import java.time.LocalDate;
import java.util.Arrays;

public class DeliveryService {

//    public LocalDate deliveryDate(Order anOrder, boolean isRush) {
//        int deliveryTime;
//
//        if (isRush) {
//            if (Arrays.asList("MA", "CT").contains(anOrder.getDeliveryState())) {
//                deliveryTime = 1;
//            } else if (Arrays.asList("NY", "NH").contains(anOrder.getDeliveryState())) {
//                deliveryTime = 2;
//            } else {
//                deliveryTime = 3;
//            }
//            return anOrder.getPlacedOn().plusDays(1 + deliveryTime);
//        } else {
//            if (Arrays.asList("MA", "CT", "NY").contains(anOrder.getDeliveryState())) {
//                deliveryTime = 2;
//            } else if (Arrays.asList("ME", "NH").contains(anOrder.getDeliveryState())) {
//                deliveryTime = 3;
//            } else {
//                deliveryTime = 4;
//            }
//            return anOrder.getPlacedOn().plusDays(2 + deliveryTime);
//        }
//    }
    // 1. 메서드 분리
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
}
