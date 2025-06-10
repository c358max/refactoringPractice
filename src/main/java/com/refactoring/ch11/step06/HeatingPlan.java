package com.refactoring.ch11.step06;

public class HeatingPlan {
    private int min;
    private int max;

    public HeatingPlan(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getTargetTemperature(Thermostat thermostat) {
        int selected = thermostat.getSelectedTemperature();

        if (selected > max) return max;
        else if (selected < min) return min;
        else return selected;
    }
}