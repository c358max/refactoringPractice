package com.refactoring.ch11.step04.asis;

public class HeatingPlan {

    private int minTemp;
    private int maxTemp;

    public HeatingPlan(int minTemp, int maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public boolean withinRange(int low, int high) {
        return low >= minTemp && high <= maxTemp;
    }
}