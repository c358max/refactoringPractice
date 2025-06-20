package com.refactoring.ch11.step06;

/**
 * 11.6 질의 함수를 매개변수로 바꾸기 (Replace Query with Parameter)
 * 호출부의 if문을 별도의 메서드로 분리하여 가독성 향상
 * regulateTemperature 메서드를 추가하여 Thermostat과 ThermostatControl 관련 로직을 분리
 */
public class HeatingPlan_03 {
    private int min;
    private int max;

    public HeatingPlan_03(int min, int max) {
        this.min = min;
        this.max = max;
    }

    // getTargetTemperature를 매개변수로 전달
    public int getTargetTemperature(int selectedTemperature) {
        if (selectedTemperature > max) return max;
        else if (selectedTemperature < min) return min;
        else return selectedTemperature;
    }

    // applyTemperatureControl 메서드를 분리하여 가독성 향상
    public void applyTemperatureControl(int target, int current, ThermostatControl controller) {
        if (target > current) {
            controller.setToHeat();
        } else if (target < current) {
            controller.setToCool();
        } else {
            controller.setOff();
        }
    }

    // Thermostat 관련 로직 분리
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