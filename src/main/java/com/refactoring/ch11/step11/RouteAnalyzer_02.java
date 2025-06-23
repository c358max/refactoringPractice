package com.refactoring.ch11.step11;

import java.util.List;

/**
 * 11.11 수정된 값 반환하기(Return Modified Value)
 * analyze() 메서드를 만들어 상태만 변경하는 명령 함수로 분리하고,
 * getPace()는 질의 함수로서 값을 반환 -> 책임 분리
 * 기존 매직넘버 상수처리
 */
public class RouteAnalyzer_02 {
    private List<Point> points;
    private double totalAscent = 0;
    private double totalTime = 0;
    private double totalDistance = 0;

    private static final double TIME_PER_POINT = 5.0;       // 분
    private static final double DISTANCE_PER_POINT = 0.1;   // km

    public RouteAnalyzer_02(List<Point> points) {
        this.points = points;
    }

    public void analyze() {
        calculateAscent();
        calculateTime();
        calculateDistance();
    }

    // 기존 computePace() 메서드를 getPace()로 변경
    public double getPace() {
        return totalTime / 60 / totalDistance;
    }

    private void calculateAscent() {
        for (int i = 1; i < points.size(); i++) {
            double verticalChange = points.get(i).getElevation() - points.get(i - 1).getElevation();
            if (verticalChange > 0)
                totalAscent += verticalChange;
        }
    }

    private void calculateTime() {
        totalTime = points.size() * TIME_PER_POINT;
    }

    private void calculateDistance() {
        totalDistance = points.size() * DISTANCE_PER_POINT;
    }

    public static void main(String[] args) {

        List<Point> points = List.of(
                new Point(10), new Point(15), new Point(12)
        );
        RouteAnalyzer_02 analyzer = new RouteAnalyzer_02(points);

        analyzer.analyze();                 // 명령
        double pace = analyzer.getPace();   // 질의

        System.out.println("페이스: " + pace);
    }
}
