package com.refactoring.ch11.step11;

import java.util.List;

public class RouteAnalyzer {
    private List<Point> points;
    private double totalAscent = 0;
    private double totalTime = 0;
    private double totalDistance = 0;

    public RouteAnalyzer(List<Point> points) {
        this.points = points;
    }

    // 내부에서 계산
    public void analyze() {
        calculateAscent();
        calculateTime();
        calculateDistance();
    }

    private void calculateAscent() {
        for (int i = 1; i < points.size(); i++) {
            double verticalChange = points.get(i).getElevation() - points.get(i - 1).getElevation();
            if (verticalChange > 0)
                totalAscent += verticalChange;
        }
    }

    private void calculateTime() {
        totalTime = points.size() * 1.5; // 예시값
    }

    private void calculateDistance() {
        totalDistance = points.size() * 0.8; // 예시값
    }

    public double getPace() {
        return totalTime / 60 / totalDistance;
    }

    public double getTotalAscent() {
        return totalAscent;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public double getTotalDistance() {
        return totalDistance;
    }
}
