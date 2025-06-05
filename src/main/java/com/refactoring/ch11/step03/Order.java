package com.refactoring.ch11.step03;

import java.time.LocalDate;

public class Order {
    private String deliveryState;
    private LocalDate placedOn;

    // 생성자
    public Order(String deliveryState, LocalDate placedOn) {
        this.deliveryState = deliveryState;
        this.placedOn = placedOn;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public LocalDate getPlacedOn() {
        return placedOn;
    }
}
