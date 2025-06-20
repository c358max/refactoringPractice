package com.refactoring.ch11.step06;

/**
 * 11.6 질의 함수를 매개변수로 바꾸기 (Replace Query with Parameter)
 * 호출부(Main)에서 동일한 thermostat 객체를 직접 참조하여 테스트 어려움
 * * getTargetTemperature 메서드에서 thermostat 객체를 매개변수로 받지 않고,
 * * selectedTemperature를 직접 전달받도록 변경
 */
public class HeatingPlan_02 {
    private int min;
    private int max;

    public HeatingPlan_02(int min, int max) {
        this.min = min;
        this.max = max;
    }

    // getTargetTemperature를 매개변수로 전달
    public int getTargetTemperature(int selectedTemperature) {
        if (selectedTemperature > max) return max;
        else if (selectedTemperature < min) return min;
        else return selectedTemperature;
    }

    public static void main(String[] args) {
        HeatingPlan_02 plan = new HeatingPlan_02(18, 26);
        Thermostat thermostat = new Thermostat(24, 20); // selected: 24, current: 20

        ThermostatControl control = new ThermostatControl();

        int selected = thermostat.getSelectedTemperature();
        int current = thermostat.getCurrentTemperature();

        int target = plan.getTargetTemperature(selected);

        if (target > current) {
            control.setToHeat();
        } else if (target < current) {
            control.setToCool();
        } else {
            control.setOff();
        }
    }
}