package com.refactoring.ch11.step09;

import com.refactoring.ch11.step09.Candidate;
import com.refactoring.ch11.step09.MedicalExam;
import com.refactoring.ch11.step09.Scorer;
import com.refactoring.ch11.step09.ScoringGuide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScorerTest {
    @Test
    @DisplayName("흡연자 + 낮은 인증지역: 건강감점 + 인증감점 적용")
    void testSmokerAndLowCertification() {
        Candidate candidate = new Candidate("TX"); // 낮은 인증 지역
        MedicalExam medicalExam = new MedicalExam(true); // 흡연자
        ScoringGuide scoringGuide = new ScoringGuide();

        Scorer scorer = new Scorer(candidate, medicalExam, scoringGuide);
        int score = scorer.execute();

        // healthLevel 10 → 감점 5, low 인증 지역 → 감점 5 → 총 -10
        assertEquals(-10, score);
    }

    @Test
    @DisplayName("비흡연자 + 낮은 인증지역: 인증감점만 적용")
    void testNonSmokerAndLowCertification() {
        Candidate candidate = new Candidate("TX"); // 낮은 인증 지역
        MedicalExam medicalExam = new MedicalExam(false); // 비흡연자
        ScoringGuide scoringGuide = new ScoringGuide();

        Scorer scorer = new Scorer(candidate, medicalExam, scoringGuide);
        int score = scorer.execute();

        // healthLevel 0 → 감점 0, 인증감점 -5 → 총 -5
        assertEquals(-5, score);
    }

    @Test
    @DisplayName("흡연자 + 일반 인증지역: 건강감점만 적용")
    void testSmokerAndRegularCertification() {
        Candidate candidate = new Candidate("CA"); // 일반 지역
        MedicalExam medicalExam = new MedicalExam(true); // 흡연자
        ScoringGuide scoringGuide = new ScoringGuide();

        Scorer scorer = new Scorer(candidate, medicalExam, scoringGuide);
        int score = scorer.execute();

        // healthLevel 10 → 감점 5, 인증감점 없음 → 총 -5
        assertEquals(-5, score);
    }

    @Test
    @DisplayName("비흡연자 + 일반 인증지역: 감점 없음")
    void testNonSmokerAndRegularCertification() {
        Candidate candidate = new Candidate("CA");
        MedicalExam medicalExam = new MedicalExam(false);
        ScoringGuide scoringGuide = new ScoringGuide();

        Scorer scorer = new Scorer(candidate, medicalExam, scoringGuide);
        int score = scorer.execute();

        // healthLevel 0, 인증 문제 없음 → 총 0
        assertEquals(0, score);
    }
}