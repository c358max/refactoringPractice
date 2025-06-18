package com.refactoring.ch11.step01;

import java.util.List;

/**
 * 11.1 질의 함수와 변경 함수 분리하기 (Seperate Query from Modifier)
 * 리팩터링 전 : 이름을 반환(질의) + 알람실행(변경) -> 테스트 어려움, 책임 혼합
 */
public class VillainDetector_01 {
    public String alertForMiscreant(List<String> people) {
        for (String p : people) {
            if (p.equals("조커")) {
                setOffAlarms();
                return "조커";
            }
            if (p.equals("사루만")) {
                setOffAlarms();
                return "사루만";
            }
        }
        return "";
    }

    private void setOffAlarms() {
        System.out.println("빌런 경고!!");
    }
}