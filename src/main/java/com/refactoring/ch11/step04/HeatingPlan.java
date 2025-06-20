package com.refactoring.ch11.step04;

import java.util.ArrayList;
import java.util.List;

/**
 * 11.4 객체 통째로 넘기기 (Preserve Whole Object)
 */
public class HeatingPlan {
    private TemperatureRange tempRange;

    public HeatingPlan(int minTemp, int maxTemp) {
        this.tempRange = new TemperatureRange(minTemp, maxTemp);
    }

    // TemperatureRange 객체를 사용하여 범위 확인
    public boolean withinRange(TemperatureRange range) {
        return range.getLow() >= tempRange.getLow()
                && range.getHigh() <= tempRange.getHigh();
    }

    public static void main(String[] args) {

        Room aRoom = new Room(18, 26);             // 방의 온도 범위 설정
        HeatingPlan_02 aPlan = new HeatingPlan_02(20, 25);    // 난방 계획의 온도 범위 설정

        List<String> alerts = new ArrayList<>();

        TemperatureRange roomRange = aRoom.getTemperatureRange();

        if (!aPlan.withinRange(roomRange)) {
            alerts.add("방 온도가 지정 범위를 벗어났습니다.");
        }

        alerts.forEach(System.out::println);
    }
}