package com.refactoring.ch11.step11;

import java.util.List;

/**
 * 11.11 수정된 값 반환하기(Return Modified Value)
 * 리팩터링 전 : computePace() 메서드가 내부 상태를 변경하면서 값을 리턴함. - 변경과 조회가 혼합됨.
 * 이로 인해 메서드의 부작용이 발생하고, 코드의 가독성과 유지보수성이 떨어짐.
 * 명령 함수와 질의 함수 분리하는게 목적임.
 */
public class RouteAnalyzer_01 {
    private List<Point> points;
    private double totalAscent = 0;
    private double totalTime = 0;
    private double totalDistance = 0;

    public RouteAnalyzer_01(List<Point> points) {
        this.points = points;
    }

    public double computePace() {
        calculateAscent();
        calculateTime();        // 15
        calculateDistance();    // 0.3
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
        totalTime = points.size() * 5;
    }

    private void calculateDistance() {
        totalDistance = points.size() * 0.1;
    }

    public static void main(String[] args) {
        // 예시 데이터 생성
        List<Point> points = List.of(
                new Point(10), new Point(15), new Point(12)
        );
        RouteAnalyzer_01 analyzer = new RouteAnalyzer_01(points);

        double pace = analyzer.computePace();
        System.out.println("페이스: " + pace);
    }
}
