package com.refactoring.ch11.step09;

import com.refactoring.ch11.step09.Candidate;
import com.refactoring.ch11.step09.MedicalExam;
import com.refactoring.ch11.step09.Scorer;
import com.refactoring.ch11.step09.ScoringGuide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScorerTest {
    @Test
    void 흡연자가_아닌_정상_지역의_점수계산() {
        Candidate candidate = new Candidate("김유신", "CA"); // CA는 정상 지역
        MedicalExam medicalExam = new MedicalExam(false); // 비흡연자
        ScoringGuide scoringGuide = new ScoringGuide();

        Scorer scorer = new Scorer(candidate, medicalExam, scoringGuide);
        int result = scorer.execute();

        assertEquals(0, result); // 감점 없음
    }

    @Test
    void 흡연자이고_저등급지역인_경우_감점() {
        Candidate candidate = new Candidate("이순신", "FL"); // FL은 저등급 지역
        MedicalExam medicalExam = new MedicalExam(true); // 흡연자
        ScoringGuide scoringGuide = new ScoringGuide();

        Scorer scorer = new Scorer(candidate, medicalExam, scoringGuide);
        int result = scorer.execute();

        assertEquals(-10, result); // 건강감점 -5, 지역감점 -5
    }
}