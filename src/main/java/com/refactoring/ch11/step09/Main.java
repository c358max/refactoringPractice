package com.refactoring.ch11.step09;

public class Main {
    public static void main(String[] args) {
        // 가상의 도메인 객체 생성
        Candidate candidate = new Candidate("홍길동", "TX");
        MedicalExam medicalExam = new MedicalExam(true); // 흡연자
        ScoringGuide scoringGuide = new ScoringGuide();

//        ScoringService service = new ScoringService();
//        int score = service.score(candidate, medicalExam, scoringGuide);
        Scorer scorer = new Scorer(candidate, medicalExam, scoringGuide);
        int score = scorer.execute();

        System.out.println("최종 점수: " + score);
    }

}
