package com.refactoring.ch11.step09;

/**
 * 11.9 함수를 명령으로 바꾸기(Replace Function with Command)
 */
public class ScoringService {
    public int score(Candidate candidate, MedicalExam exam, ScoringGuide guide) {
        return new Scorer(candidate, exam, guide).execute();
    }

    public static void main(String[] args) {

        Candidate candidate = new Candidate("TX");    // 텍사스
        MedicalExam medicalExam = new MedicalExam(true); // 흡연자
        ScoringGuide scoringGuide = new ScoringGuide();

        ScoringService_03 service = new ScoringService_03();
        int score = service.score(candidate, medicalExam, scoringGuide);

        System.out.println("최종 점수: " + score);
    }
}
