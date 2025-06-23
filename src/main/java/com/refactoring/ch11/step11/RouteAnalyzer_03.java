package com.refactoring.ch11.step11;

import java.util.List;

/**
 * 11.11 수정된 값 반환하기(Return Modified Value)
 * AnalysisREsultDto를 사용하여 분석 결과를 반환하는 방식으로 변경
 * 메서드명을 구체적으로 변경하여 책임을 분리
 */
public class RouteAnalyzer_03 {
    private List<Point> points;
    private double totalAscent = 0;
    private double totalTime = 0;
    private double totalDistance = 0;

    private static final double TIME_PER_POINT = 5.0;       // 분
    private static final double DISTANCE_PER_POINT = 0.1;   // km

    public RouteAnalyzer_03(List<Point> points) {
        this.points = points;
    }

    public AnalysisResultDto analyze() {
        computeTotalAscent();
        computeTotalTimeBasedOnPointCount();
        computeTotalDistance();
        double pace = getPace();

        return new AnalysisResultDto(totalAscent, totalTime, totalDistance, getPace());
    }

    // 기존 computePace() 메서드를 getPace()로 변경
    public double getPace() {
        return totalTime / 60 / totalDistance;
    }

    private void computeTotalAscent() {
        for (int i = 1; i < points.size(); i++) {
            double verticalChange = points.get(i).getElevation() - points.get(i - 1).getElevation();
            if (verticalChange > 0)
                totalAscent += verticalChange;
        }
    }

    private void computeTotalTimeBasedOnPointCount() {
        totalTime = points.size() * TIME_PER_POINT;
    }

    private void computeTotalDistance() {
        totalDistance = points.size() * DISTANCE_PER_POINT;
    }

    public static void main(String[] args) {

        List<Point> points = List.of(
                new Point(10), new Point(15), new Point(12)
        );
        RouteAnalyzer_03 analyzer = new RouteAnalyzer_03(points);

        analyzer.analyze();                 // 명령
        double pace = analyzer.getPace();   // 질의

        System.out.println("페이스: " + pace);
    }
}
