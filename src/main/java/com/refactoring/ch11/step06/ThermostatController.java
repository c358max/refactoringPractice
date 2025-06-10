package com.refactoring.ch11.step06;

public class ThermostatController {

    public String decideMode(HeatingPlan plan, Thermostat thermostat) {
        int targetTemp = plan.getTargetTemperature(thermostat);
        int currentTemp = thermostat.getCurrentTemperature();

        if (targetTemp > currentTemp) return "HEAT";
        else if (targetTemp < currentTemp) return "COOL";
        else return "OFF";
    }

    public void setToHeat() {
        System.out.println("난방을 시작합니다. (HEAT ON)");
    }

    public void setToCool() {
        System.out.println("냉방을 시작합니다. (COOL ON)");
    }

    public void setOff() {
        System.out.println("모든 장치를 종료합니다. (OFF)");
    }
}
