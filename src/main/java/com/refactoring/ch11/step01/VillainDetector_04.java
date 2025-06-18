package com.refactoring.ch11.step01;

import org.apache.logging.log4j.util.Strings;

import java.util.List;
import java.util.Set;

/**
 * 11.1 질의 함수와 변경 함수 분리하기 (Seperate Query from Modifier)
 * * 추가 리팩터링 : 상수로 정의후 로직 간결화
 */
public class VillainDetector_04 {

    // 악당 이름 상수로 정의
    private static final Set<String> MISCREANTS = Set.of("조커", "사루만");

    public void alertForMiscreant(List<String> people) {
        if (!findMiscreant(people).isEmpty()) {
            setOffAlarms();
        }
    }

    // 로직 리팩터링
    public String findMiscreant(List<String> people) {
//        for (String p : people) {
//            if (p.equals("조커") || p.equals("사루만")) {
//                return p;
//            }
//        }
//        return Strings.EMPTY;
        return people.stream()
                .filter(MISCREANTS::contains)
                .findFirst()
                .orElse(Strings.EMPTY);
    }

    private void setOffAlarms() {
        System.out.println("빌런 경고!!");
    }
}