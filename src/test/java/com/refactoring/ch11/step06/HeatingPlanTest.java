package com.refactoring.ch11.step06;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeatingPlanTest {

    @Test
    @DisplayName("선택 온도가 현재보다 높을 경우 -> HEAT")
    void testRegulateTemperature_Heat() {
        HeatingPlan plan = new HeatingPlan(18, 26);
        Thermostat thermostat = new Thermostat(24, 20); // selected > current
        ThermostatControl control = new ThermostatControl();

        plan.regulateTemperature(thermostat, control);

        assertEquals("HEAT", control.setToHeat());
    }

    @Test
    @DisplayName("선택 온도가 현재보다 낮을 경우 -> COOL")
    void testRegulateTemperature_Cool() {
        HeatingPlan plan = new HeatingPlan(18, 26);
        Thermostat thermostat = new Thermostat(20, 22); // selected < current
        ThermostatControl control = new ThermostatControl();

        plan.regulateTemperature(thermostat, control);

        assertEquals("COOL", control.setToCool());
    }

    @Test
    @DisplayName("선택 온도가 현재와 같을 경우 -> OFF")
    void testRegulateTemperature_Off() {
        HeatingPlan plan = new HeatingPlan(18, 26);
        Thermostat thermostat = new Thermostat(21, 21); // selected == current
        ThermostatControl control = new ThermostatControl();

        plan.regulateTemperature(thermostat, control);

        assertEquals("OFF", control.setOff());
    }
}