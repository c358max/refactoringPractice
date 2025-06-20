package com.refactoring.ch11.step06;

// 온도조절
public class ThermostatControl {

    public String decideMode(HeatingPlan plan, Thermostat thermostat) {
        int targetTemp = plan.getTargetTemperature(thermostat.getSelectedTemperature());
        int currentTemp = thermostat.getCurrentTemperature();

        if (targetTemp > currentTemp) return "HEAT";
        else if (targetTemp < currentTemp) return "COOL";
        else return "OFF";
    }

    public String setToHeat() {
        System.out.println("난방을 시작합니다. (HEAT ON)");
        return "HEAT";
    }

    public String setToCool() {
        System.out.println("냉방을 시작합니다. (COOL ON)");
        return "COOL";
    }

    public String setOff() {
        System.out.println("모든 장치를 종료합니다. (OFF)");
        return "OFF";
    }
}
