package com.refactoring.ch11.step09;

/**
 * 11.9 함수를 명령으로 바꾸기(Replace Function with Command)
 * 기존 계산로직을 별도의 클래스(Score)로 분리하여 책임을 명확히 하고 가독성을 향상시킴
 * Scorer 클래스의 execute() 메서드를 호출하여 점수를 계산
 */
public class ScoringService_02 {
    public int score(Candidate candidate, MedicalExam exam, ScoringGuide guide) {
        return new Scorer_01(candidate, exam, guide).execute();
    }

    public static void main(String[] args) {

        Candidate candidate = new Candidate("TX");    // 텍사스
        MedicalExam medicalExam = new MedicalExam(true); // 흡연자
        ScoringGuide scoringGuide = new ScoringGuide();

        ScoringService_02 service = new ScoringService_02();
        int score = service.score(candidate, medicalExam, scoringGuide);

        System.out.println("최종 점수: " + score);
    }
}
