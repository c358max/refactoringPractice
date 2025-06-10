package com.refactoring.ch11.step11;

import java.util.List;

public class RouteAnalyzerRefactored {
    private List<Point> points;

    public RouteAnalyzerRefactored(List<Point> points) {
        this.points = points;
    }

    // 고도 계산
    public double calculateTotalAscent() {
        double totalAscent = 0;
        for (int i = 1; i < points.size(); i++) {
            double verticalChange = points.get(i).getElevation() - points.get(i - 1).getElevation();
            if (verticalChange > 0)
                totalAscent += verticalChange;
        }
        return totalAscent;
    }

    // 총 시간 계산
    public double calculateTotalTime() {
        return points.size() * 1.5; // 예시
    }

    // 총 거리 계산
    public double calculateTotalDistance() {
        return points.size() * 0.8; // 예시
    }

    // 평균 페이스
    public double calculatePace() {
        double totalTime = calculateTotalTime();
        double totalDistance = calculateTotalDistance();

        return totalTime / 60 / totalDistance;
    }
}
