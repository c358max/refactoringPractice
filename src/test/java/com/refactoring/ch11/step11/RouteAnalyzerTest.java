package com.refactoring.ch11.step11;

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

    @Test
    void analyze_호출_후_총상승고도_검증() {
        RouteAnalyzer analyzer = new RouteAnalyzer(samplePoints());
        analyzer.analyze();

        assertEquals(45.0, analyzer.getTotalAscent(), 0.001);
    }

    @Test
    void analyze_호출_후_총시간_검증() {
        RouteAnalyzer analyzer = new RouteAnalyzer(samplePoints());
        analyzer.analyze();

        assertEquals(7.5, analyzer.getTotalTime(), 0.001);
    }

    @Test
    void analyze_호출_후_총거리_검증() {
        RouteAnalyzer analyzer = new RouteAnalyzer(samplePoints());
        analyzer.analyze();

        assertEquals(4.0, analyzer.getTotalDistance(), 0.001);
    }

    @Test
    void analyze_호출_후_페이스_검증() {
        RouteAnalyzer analyzer = new RouteAnalyzer(samplePoints());
        analyzer.analyze();

        assertEquals(0.03125, analyzer.getPace(), 0.0001);
    }
}