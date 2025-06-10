package com.refactoring.ch11.step11;

import java.util.Arrays;
import java.util.List;

public class Main {
/*
    // 리팩터링 전
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point(100),
                new Point(120),
                new Point(115),
                new Point(140),
                new Point(135)
        );

        RouteAnalyzer analyzer = new RouteAnalyzer(points);
        analyzer.analyze(); // 내부에서 상태 직접 변경

        double totalAscent = analyzer.getTotalAscent();
        double totalTime = analyzer.getTotalTime();
        double totalDistance = analyzer.getTotalDistance();
        double pace = analyzer.getPace();

        System.out.println("총 상승 고도: " + totalAscent);
        System.out.println("총 시간: " + totalTime + "분");
        System.out.println("총 거리: " + totalDistance + "km");
        System.out.println("평균 페이스: " + pace + " km/h");
    }
*/
    // 리팩터링 후
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point(100),
                new Point(120),
                new Point(115),
                new Point(140),
                new Point(135)
        );

        RouteAnalyzerRefactored analyzer = new RouteAnalyzerRefactored(points);

        double totalAscent = analyzer.calculateTotalAscent();
        double totalTime = analyzer.calculateTotalTime();
        double totalDistance = analyzer.calculateTotalDistance();
        double pace = analyzer.calculatePace();

        System.out.println("총 상승 고도: " + totalAscent);
        System.out.println("총 시간: " + totalTime + "분");
        System.out.println("총 거리: " + totalDistance + "km");
        System.out.println("평균 페이스: " + pace + " km/h");
    }


}
