package com.refactoring.ch11.step06;

/**
 * 11.6 질의 함수를 매개변수로 바꾸기 (Replace Query with Parameter)
 * * 11.5 매개변수를 질의 함수로 바꾸기 (Replace Parameter with Query)와 반대개념
 * * 중복 호출을 제거하여 코드의 가독성과 유지보수성을 향상시키는게 목적
 *  질의 함수에서 계산된 값을 매개변수로 전달받아 호출자가 미리 계산하도록 변경
 */
public class HeatingPlan_01 {
    private int min;
    private int max;

    public HeatingPlan_01(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getTargetTemperature(Thermostat thermostat) {
        int selected = thermostat.getSelectedTemperature();

        if (selected > max) return max;
        else if (selected < min) return min;
        else return selected;
    }

    public static void main(String[] args) {
        HeatingPlan_01 thePlan = new HeatingPlan_01(18, 26);
        Thermostat thermostat = new Thermostat(24, 20); // selected: 24, current: 20

        ThermostatControl control = new ThermostatControl();

        // thePlan.getTargetTemperature 메서드를 2번 호출중.
        if (thePlan.getTargetTemperature(thermostat) > thermostat.getCurrentTemperature()) {
            control.setToHeat();
        } else if (thePlan.getTargetTemperature(thermostat) < thermostat.getCurrentTemperature()) {
            control.setToCool();
        } else {
            control.setOff();
        }
    }
}