package com.refactoring.ch11.step04;

/**
 * TemperatureRange 클래스를 사용하여 리팩터링
 */
public class Room {

    private TemperatureRange tempRange;

    private int low;    // 방의 최저 온도
    private int high;   // 방의 최고 온도

    public Room(int low, int high) {
        this.low = low;     // 삭제예정
        this.high = high;   // 삭제예정

        this.tempRange = new TemperatureRange(low, high); // 온도 범위를 TemperatureRange로 관리
    }

    public TemperatureRange getTemperatureRange() {
        return tempRange;
    }

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }
}