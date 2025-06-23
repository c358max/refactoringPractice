package com.refactoring.ch11.step11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RouteAnalyzerTest {
    private List<Point> samplePoints() {
        return Arrays.asList(
                new Point(100),
                new Point(120),  // +20
                new Point(115),  // -5
                new Point(140),  // +25
                new Point(135)   // -5
        );
    }

    @DisplayName("analyze() 호출 후 총 상승 고도 검증") // 총상승고도 = 20 + 25 = 45
    @Test
    void shouldCalculateTotalAscentCorrectly() {
        RouteAnalyzer analyzer = new RouteAnalyzer(samplePoints());
        AnalysisResultDto result = analyzer.analyze();

        assertEquals(45.0, result.totalAscent, 0.001);
    }

    @DisplayName("analyze() 호출 후 총 시간 검증") // 시간 = 5개 포인트 * 1.5분 = 7.5분
    @Test
    void shouldCalculateTotalTimeCorrectly() {
        RouteAnalyzer analyzer = new RouteAnalyzer(samplePoints());
        AnalysisResultDto result = analyzer.analyze();

        assertEquals(25.0, result.totalTime, 0.001);
    }

    @DisplayName("analyze() 호출 후 총 거리 검증") // 거리 = 5개 포인트 * 0.1km = 4.0km
    @Test
    void shouldCalculateTotalDistanceCorrectly() {
        RouteAnalyzer analyzer = new RouteAnalyzer(samplePoints());
        AnalysisResultDto result = analyzer.analyze();

        assertEquals(0.5, result.totalDistance, 0.001);
    }

    @DisplayName("analyze() 호출 후 페이스 계산 검증") // 페이스 = (7.5분 / 60) / 4.0km
    @Test
    void shouldCalculatePaceCorrectly() {
        RouteAnalyzer analyzer = new RouteAnalyzer(samplePoints());
        AnalysisResultDto result = analyzer.analyze();

        assertEquals(0.8333333333333334, result.pace, 0.0001);
    }
}