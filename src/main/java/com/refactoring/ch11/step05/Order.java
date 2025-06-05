package com.refactoring.ch11.step05;

import java.util.List;

public class Order {
    private List<Item> items;

    public Order(List<Item> items) {
        this.items = items;
    }

    // 리팩터링 전
//    public int calculateTotalPrice(int itemCount) {
//        return itemCount * 1000; // 예: 개당 1000원
//    }

    //
    public int calculateTotalPrice() {
        return getItemCount() * 1000; // 예: 개당 1000원
    }

    public int getItemCount() {
        return items.size();
    }
}
