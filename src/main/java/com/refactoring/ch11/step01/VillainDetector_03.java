package com.refactoring.ch11.step01;

import org.apache.logging.log4j.util.Strings;

import java.util.List;

/**
 * 11.1 질의 함수와 변경 함수 분리하기 (Seperate Query from Modifier)
 * * 복제 함수 findMiscreant()에서 부수효과 제거 - setOffAlarms() 제거
 * * alertForMiscreant() 에서는 알람만 실행하도록 변경
 */
public class VillainDetector_03 {

    public void alertForMiscreant(List<String> people) {
//        for (String p : people) {
//            if (p.equals("조커")) {
//                setOffAlarms();
//                return "조커";
//            }
//            if (p.equals("사루만")) {
//                setOffAlarms();
//                return "사루만";
//            }
//        }
//        return "";
        if (!findMiscreant(people).isEmpty()) {
            setOffAlarms();
        }
    }

    public String findMiscreant(List<String> people) {
        for (String p : people) {
            if (p.equals("조커")) {
//                setOffAlarms();       // 부수효과 제거
                return "조커";
            }
            if (p.equals("사루만")) {
//                setOffAlarms();       // 부수효과 제거
                return "사루만";
            }
        }
        return Strings.EMPTY;
    }

    private void setOffAlarms() {
        System.out.println("빌런 경고!!");
    }
}