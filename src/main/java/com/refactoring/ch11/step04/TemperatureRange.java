package com.refactoring.ch11.step04;

/**
 * TemperatureRange 클래스는 온도 범위를 나타냅니다.
 * low와 high 속성을 가지고 있으며, 생성자를 통해 초기화
 * getLow()와 getHigh() 메서드를 통해 각각의 값을 반환
 */
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
