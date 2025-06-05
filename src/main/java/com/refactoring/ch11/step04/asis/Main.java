package com.refactoring.ch11.step04.asis;

import com.refactoring.ch11.step04.tobe.TemperatureRange;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // 리팩터링 전
    public static void main(String[] args) {
        // Room은 온도를 직접 가지고 있음
        Room aRoom = new Room(18, 26);

        // HeatingPlan도 온도를 직접 가지고 있음
        HeatingPlan aPlan = new HeatingPlan(20, 25);

        List<String> alerts = new ArrayList<>();

        int low = aRoom.getLow();
        int high = aRoom.getHigh();

        if (!aPlan.withinRange(low, high)) {
            alerts.add("방 온도가 지정 범위를 벗어났습니다.");
        }

        alerts.forEach(System.out::println);
    }
}
