package com.refactoring.ch11.step09;

/**
 * 11.9 함수를 명령으로 바꾸기(Replace Function with Command)
 * 리팩터링 전 : score 메서드가 건강점수를 계산하는 하나의 긴 함수로 작성되어 있음
 * 지역변수가 많고 복잡한 로직이 포함되어 있어 가독성이 떨어짐
 * 긴 함수의 로직을 별도의 클래스로 분리하여 책임을 명확히 하고 가독성을 향상시키는 것이 목적
 */
public class ScoringService_01 {
    public int score(Candidate candidate, MedicalExam medicalExam, ScoringGuide scoringGuide) {
        int result = 0;
        int healthLevel = 0;
        boolean highMedicalRiskFlag = false;

        if (medicalExam.isSmoker()) {
            healthLevel += 10;
            highMedicalRiskFlag = true;
        }

        String certificationGrade = "regular";
        if (scoringGuide.stateWithLowCertification(candidate.getOriginState())) {
            certificationGrade = "low";
            result -= 5;
        }

        result -= Math.max(healthLevel - 5, 0);
        return result;
    }

    public static void main(String[] args) {

        Candidate candidate = new Candidate("TX");    // 텍사스
        MedicalExam medicalExam = new MedicalExam(true); // 흡연자
        ScoringGuide scoringGuide = new ScoringGuide();

        ScoringService_01 service = new ScoringService_01();
        int score = service.score(candidate, medicalExam, scoringGuide);

        System.out.println("최종 점수: " + score);
    }
}
