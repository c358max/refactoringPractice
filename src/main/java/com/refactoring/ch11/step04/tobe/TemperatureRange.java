package com.refactoring.ch11.step04.tobe;

// 방의 온도 범위를 나타내는 클래스
public class TemperatureRange {
    private int low;
    private int high;

    public TemperatureRange(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }
}
