package com.refactoring.ch11.step11;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RouteAnalyzerRefactoredTest {
    private List<Point> samplePoints() {
        return Arrays.asList(
                new Point(100),  // 시작
                new Point(120),  // +20
                new Point(115),  // -5
                new Point(140),  // +25
                new Point(135)   // -5
        );
    }

    @Test
    void calculateTotalAscent_정상동작() {
        RouteAnalyzerRefactored analyzer = new RouteAnalyzerRefactored(samplePoints());

        double totalAscent = analyzer.calculateTotalAscent();

        // 상승 고도: (120 - 100) + (140 - 115) = 20 + 25 = 45
        assertEquals(45.0, totalAscent, 0.001);
    }

    @Test
    void calculateTotalTime_정상동작() {
        RouteAnalyzerRefactored analyzer = new RouteAnalyzerRefactored(samplePoints());

        double totalTime = analyzer.calculateTotalTime();

        // samplePoints.size() * 1.5 = 5 * 1.5 = 7.5
        assertEquals(7.5, totalTime, 0.001);
    }

    @Test
    void calculateTotalDistance_정상동작() {
        RouteAnalyzerRefactored analyzer = new RouteAnalyzerRefactored(samplePoints());

        double totalDistance = analyzer.calculateTotalDistance();

        // samplePoints.size() * 0.8 = 5 * 0.8 = 4.0
        assertEquals(4.0, totalDistance, 0.001);
    }

    @Test
    void calculatePace_정상동작() {
        RouteAnalyzerRefactored analyzer = new RouteAnalyzerRefactored(samplePoints());

        double pace = analyzer.calculatePace();

        // totalTime / 60 / totalDistance = 7.5 / 60 / 4.0 = 0.03125
        assertEquals(0.03125, pace, 0.0001);
    }
}