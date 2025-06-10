package com.refactoring.ch11.step05;

import java.util.List;

public class Order {
    private int quantity;
    private double itemPrice;

    public Order(int quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

// 리팩터링 전
//    public double getFinalPrice() {
//        double basePrice = quantity * itemPrice;
//        int discountLevel = (quantity > 100) ? 2 : 1;
//        return discountPrice(basePrice, discountLevel);
//    }
//
//    private double discountPrice(double basePrice, int discountLevel) {
//        switch (discountLevel) {
//            case 1:
//                return basePrice * 0.95;
//            case 2:
//                return basePrice * 0.9;
//            default:
//                throw new IllegalArgumentException("Unknown discount level: " + discountLevel);
//        }
//    }

    // 리팩터링 후
    public double getFinalPrice() {
        double basePrice = quantity * itemPrice;
        return discountPrice(basePrice); // discountLevel 제거됨
    }

    //
    private int getDiscountLevel() {
        return (quantity > 100) ? 2 : 1;
    }

    public double discountPrice(double basePrice) {
        switch (getDiscountLevel()) {
            case 1: return basePrice * 0.95;
            case 2: return basePrice * 0.9;
            default: throw new IllegalArgumentException("Unknown discount level");
        }
    }
}