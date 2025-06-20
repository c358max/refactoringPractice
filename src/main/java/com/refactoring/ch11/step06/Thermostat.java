package com.refactoring.ch11.step06;

// 온도조절기
public class Thermostat {
    private int selectedTemperature;    // 선택된 온도
    private int currentTemperature;     // 현재 온도

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