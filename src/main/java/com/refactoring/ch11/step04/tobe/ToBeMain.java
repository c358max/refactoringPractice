package com.refactoring.ch11.step04.tobe;

import java.util.ArrayList;
import java.util.List;

public class ToBeMain {

    // 리팩터링 후
    public static void main(String[] args) {
        // Room은 TemperatureRange 객체를 사용
        ToBeRoom aToBeRoom = new ToBeRoom(new TemperatureRange(18, 26));
        ToBeHeatingPlan aPlan = new ToBeHeatingPlan(new TemperatureRange(20, 25));

        List<String> alerts = new ArrayList<>();

        if (!aPlan.withinRange(aToBeRoom.getDaysTempRange())) {
            alerts.add("방 온도가 지정 범위를 벗어났습니다.");
        }

        alerts.forEach(System.out::println);
    }


}
