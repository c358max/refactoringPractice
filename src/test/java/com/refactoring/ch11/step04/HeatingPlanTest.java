package com.refactoring.ch11.step04;

import com.refactoring.ch11.step04.HeatingPlan;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeatingPlanTest {


    @DisplayName("온도 범위가 계획된 범위 내에 있는지 확인")
    @Test
    public void testWithinRangeTrue() {
        HeatingPlan plan = new HeatingPlan(20, 25);
        Room room = new Room(21, 24);
        assertTrue(plan.withinRange(room.getTemperatureRange()));
    }

    @DisplayName("온도 범위가 계획된 최저온도를 벗어나는지 확인")
    @Test
    public void testWithinRangeLowBelow() {
        HeatingPlan plan = new HeatingPlan(20, 25);
        Room room = new Room(18, 24);
        assertFalse(plan.withinRange(room.getTemperatureRange()));
    }

    @DisplayName("온도 범위가 계획된 최고온도를 벗어나는지 확인")
    @Test
    public void testWithinRangeHighAbove() {
        HeatingPlan plan = new HeatingPlan(20, 25);
        Room room = new Room(21, 26);
        assertFalse(plan.withinRange(room.getTemperatureRange()));
    }

    @DisplayName("온도 범위가 계획된 최저, 최고온도를 벗어나는지 확인")
    @Test
    public void testWithinRangeBothOutside() {
        HeatingPlan plan = new HeatingPlan(20, 25);
        Room room = new Room(18, 27);
        assertFalse(plan.withinRange(room.getTemperatureRange()));
    }
}