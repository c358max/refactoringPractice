package com.refactoring.ch11.step01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VillainDetectorTest {
    @Test
    void testFindMiscreant() {
        // given
        VillainDetector detector = new VillainDetector();
        List<String> people = List.of("배트맨", "조커", "슈퍼맨");

        // when
        String result = detector.findMiscreant(people);
        detector.alertForMiscreant(people);

        // then
        assertEquals("조커", result);
    }
}