package com.refactoring.ch11.step04.tobe;

public class ToBeHeatingPlan {

    private TemperatureRange temperatureRange;

    public ToBeHeatingPlan(TemperatureRange temperatureRange) {
        this.temperatureRange = temperatureRange;
    }

    public boolean withinRange(TemperatureRange range) {
        return range.getLow() >= temperatureRange.getLow()
                && range.getHigh() <= temperatureRange.getHigh();

        // 또는 위임 방식
        // return temperatureRange.includes(range);
    }
}
