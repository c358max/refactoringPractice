package com.refactoring.ch11.step11;

public class AnalysisResultDto {
    public final double totalAscent;
    public final double totalTime;
    public final double totalDistance;
    public final double pace;

    public AnalysisResultDto(double totalAscent, double totalTime, double totalDistance, double pace) {
        this.totalAscent = totalAscent;
        this.totalTime = totalTime;
        this.totalDistance = totalDistance;
        this.pace = pace;
    }
}
