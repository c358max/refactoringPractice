package com.refactoring.ch11.step04;

import com.refactoring.ch11.step04.asis.HeatingPlan;
import com.refactoring.ch11.step04.tobe.TemperatureRange;
import com.refactoring.ch11.step04.tobe.ToBeHeatingPlan;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToBeHeatingPlanTest {

    // 기존 HeatingPlan 클래스의 테스트
    @Test
    void testWithinRange_true() {
        HeatingPlan plan = new HeatingPlan(20, 25);
        assertTrue(plan.withinRange(21, 24));
    }

    @Test
    void testWithinRange_tooLow() {
        HeatingPlan plan = new HeatingPlan(20, 25);
        assertFalse(plan.withinRange(18, 24));
    }

    @Test
    void testWithinRange_tooHigh() {
        HeatingPlan plan = new HeatingPlan(20, 25);
        assertFalse(plan.withinRange(21, 26));
    }

    // 리팩터링 후 ToBeHeatingPlan 클래스의 테스트
    @Test
    void testWithinRange() {
        ToBeHeatingPlan plan = new ToBeHeatingPlan(new TemperatureRange(18, 24));
        TemperatureRange room = new TemperatureRange(19, 23);
        assertTrue(plan.withinRange(room));
    }

    @Test
    void testOutOfRangeLow() {
        ToBeHeatingPlan plan = new ToBeHeatingPlan(new TemperatureRange(18, 24));
        TemperatureRange room = new TemperatureRange(16, 23);
        assertFalse(plan.withinRange(room));
    }

    @Test
    void testOutOfRangeHigh() {
        ToBeHeatingPlan plan = new ToBeHeatingPlan(new TemperatureRange(18, 24));
        TemperatureRange room = new TemperatureRange(19, 25);
        assertFalse(plan.withinRange(room));
    }
}