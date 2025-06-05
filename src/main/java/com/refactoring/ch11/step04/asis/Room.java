package com.refactoring.ch11.step04.asis;

import com.refactoring.ch11.step04.tobe.TemperatureRange;

public class Room {
    //
    private int low;    // 방의 최저 온도
    private int high;   // 방의 최고 온도

    public Room(int low, int high) {
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