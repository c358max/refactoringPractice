package com.refactoring.ch11.step06;

/**
 * 11.6 질의 함수를 매개변수로 바꾸기 (Replace Query with Parameter)
 */
public class HeatingPlan {
    private int min;
    private int max;

    public HeatingPlan(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getTargetTemperature(int selectedTemperature) {
        if (selectedTemperature > max) return max;
        else if (selectedTemperature < min) return min;
        else return selectedTemperature;
    }

    public void applyTemperatureControl(int target, int current, ThermostatControl controller) {
        if (target > current) {
            controller.setToHeat();
        } else if (target < current) {
            controller.setToCool();
        } else {
            controller.setOff();
        }
    }

    public void regulateTemperature(Thermostat thermostat, ThermostatControl control) {
        int target = getTargetTemperature(thermostat.getSelectedTemperature());
        int current = thermostat.getCurrentTemperature();
        applyTemperatureControl(target, current, control);
    }

    public static void main(String[] args) {
        HeatingPlan_03 plan = new HeatingPlan_03(18, 26);
        Thermostat thermostat = new Thermostat(24, 20); // selected: 24, current: 20
        ThermostatControl controller = new ThermostatControl();

        plan.regulateTemperature(thermostat, controller);
    }
}