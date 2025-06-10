package com.refactoring.ch11.step06;

public class Main {

    public static void main(String[] args) {
        HeatingPlan thePlan = new HeatingPlan(18, 26);
        Thermostat thermostat = new Thermostat(24, 20); // selected: 24, current: 20

        ThermostatController controller = new ThermostatController();

        // 리팩터링 전 : getTargetTemperature를 2번 호출하여 비교.
//        if (thePlan.getTargetTemperature(thermostat) > thermostat.getCurrentTemperature()) {
//            controller.setToHeat();
//        } else if (thePlan.getTargetTemperature(thermostat) < thermostat.getCurrentTemperature()) {
//            controller.setToCool();
//        } else {
//            controller.setOff();
//        }

        // 리팩터링 후 : getTargetTemperature를 1번만 호출하여 비교.
        int targetTemp = thePlan.getTargetTemperature(thermostat);

        if (targetTemp > thermostat.getCurrentTemperature()) {
            controller.setToHeat();
        } else if (targetTemp < thermostat.getCurrentTemperature()) {
            controller.setToCool();
        } else {
            controller.setOff();
        }
    }
}
