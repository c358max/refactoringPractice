package com.refactoring.ch11.step06;

public class Thermostat {
    private int selectedTemperature;
    private int currentTemperature;

    public Thermostat(int selectedTemperature, int currentTemperature) {
        this.selectedTemperature = selectedTemperature;
        this.currentTemperature = currentTemperature;
    }

    public int getSelectedTemperature() {
        return selectedTemperature;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }
}