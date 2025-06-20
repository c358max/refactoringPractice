package com.refactoring.ch11.step04;

import java.util.ArrayList;
import java.util.List;

/**
 * 11.4 객체 통째로 넘기기 (Preserve Whole Object)
 * 리팩터링 전: Room의 온도를 직접 가져와 HeatingPlan에 전달
 * Room과 HeatingPlan이 각각 온도를 직접 가지고 있음.
 * -> 여러개의 매개변수가 논리적으로 하나의 개념을 표현할 때, 이를 객체로 묶어서 전달하면
 * 코드의 명확성, 유지보수성, 확장성을 향상시킬 수 있음.
 */
public class HeatingPlan_01 {

    private int minTemp;
    private int maxTemp;

    public HeatingPlan_01(int minTemp, int maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    // 리팩터링 전: low와 high를 각각 전달
    public boolean withinRange(int low, int high) {
        return low >= minTemp && high <= maxTemp;
    }

    public static void main(String[] args) {

        Room aRoom = new Room(18, 26);             // 방의 온도 범위 설정
        HeatingPlan_01 aPlan = new HeatingPlan_01(20, 25);    // 난방 계획의 온도 범위 설정

        // 경고 메시지를 담을 리스트 생성
        List<String> alerts = new ArrayList<>();

        int low = aRoom.getLow();
        int high = aRoom.getHigh();

        // HeatingPlan에 low와 high를 각각 전달하여 범위 확인
        if (!aPlan.withinRange(low, high)) {
            alerts.add("방 온도가 지정 범위를 벗어났습니다.");
        }

        alerts.forEach(System.out::println);
    }
}