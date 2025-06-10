package com.refactoring.ch11.step06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testShouldHeatWhenTargetTempHigher() {
        HeatingPlan plan = new HeatingPlan(18, 26);
        Thermostat thermostat = new Thermostat(24, 20); // selectedTemp = 24, currentTemp = 20

        ThermostatController controller = new ThermostatController();
        String result = controller.decideMode(plan, thermostat);

        assertEquals("HEAT", result);
    }

    @Test
    void testShouldCoolWhenTargetTempLower() {
        HeatingPlan plan = new HeatingPlan(18, 26);
        Thermostat thermostat = new Thermostat(15, 20); // selectedTemp = 15 → clamped to 18

        ThermostatController controller = new ThermostatController();
        String result = controller.decideMode(plan, thermostat);

        assertEquals("COOL", result);
    }

    @Test
    void testShouldTurnOffWhenTempMatches() {
        HeatingPlan plan = new HeatingPlan(18, 26);
        Thermostat thermostat = new Thermostat(22, 22);

        ThermostatController controller = new ThermostatController();
        String result = controller.decideMode(plan, thermostat);

        assertEquals("OFF", result);
    }

    @Test
    void testClampSelectedTempAboveMax() {
        HeatingPlan plan = new HeatingPlan(18, 26);
        Thermostat thermostat = new Thermostat(30, 20); // selectedTemp = 30 → clamped to 26

        ThermostatController controller = new ThermostatController();
        String result = controller.decideMode(plan, thermostat);

        assertEquals("HEAT", result); // 26 > 20 → HEAT
    }
}