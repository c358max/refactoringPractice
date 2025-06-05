package com.refactoring.ch11.step04.tobe;

public class ToBeRoom {

    // TemperatureRange 객체로 변경
    private TemperatureRange daysTempRange;

    public ToBeRoom(TemperatureRange daysTempRange) {
        this.daysTempRange = daysTempRange;
    }

    public TemperatureRange getDaysTempRange() {
        return daysTempRange;
    }
}