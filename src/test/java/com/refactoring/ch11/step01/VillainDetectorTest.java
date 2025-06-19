package com.refactoring.ch11.step01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VillainDetectorTest {
    private final VillainDetector detector = new VillainDetector();

    @DisplayName("리스트에 조커가 있을때 리턴")
    @Test
    void testFindMiscreant_returnsFirstMiscreant() {
        List<String> people = Arrays.asList("배트맨", "조커", "사루만");
        String result = detector.findMiscreant(people);
        assertEquals("조커", result);
    }

    @DisplayName("리스트에 조커는 없고 사루만만 있을때 리턴")
    @Test
    void testFindMiscreant_returnsSecondMiscreantIfFirstNotFound() {
        List<String> people = Arrays.asList("배트맨", "슈퍼맨", "사루만");
        String result = detector.findMiscreant(people);
        assertEquals("사루만", result);
    }

    @DisplayName("빌런이 없는 경우 빈 문자열 리턴")
    @Test
    void testFindMiscreant_returnsEmptyIfNoMiscreant() {
        List<String> people = Arrays.asList("배트맨", "슈퍼맨", "원더우먼");
        String result = detector.findMiscreant(people);
        assertEquals("", result);
    }

    @DisplayName("리스트가 비어 있는 경우 처리확인")
    @Test
    void testFindMiscreant_returnsEmptyIfListEmpty() {
        List<String> people = Collections.emptyList();
        String result = detector.findMiscreant(people);
        assertEquals("", result);
    }
}