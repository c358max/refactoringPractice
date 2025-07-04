package com.refactoring.ch11.step01;

import org.apache.logging.log4j.util.Strings;

import java.util.List;
import java.util.Set;

/**
 * 11.1 질의 함수와 변경 함수 분리하기 (Seperate Query from Modifier)
 */
public class VillainDetector {

    private static final Set<String> MISCREANTS = Set.of("조커", "사루만");

    public void alertForMiscreant(List<String> people) {
        if (!findMiscreant(people).isEmpty()) {
            setOffAlarms();
        }
    }

    public String findMiscreant(List<String> people) {
        return people.stream()
                .filter(MISCREANTS::contains)
                .findFirst()
                .orElse(Strings.EMPTY);
    }

    private void setOffAlarms() {
        System.out.println("빌런 경고!!");
    }
}