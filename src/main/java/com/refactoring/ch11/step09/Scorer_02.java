package com.refactoring.ch11.step09;

/**
 * 11.9 함수를 명령으로 바꾸기(Replace Function with Command)
 * execute() 메서드의 로직을 별도의 메서드로 분리하여 가독성을 향상시킴
 */
public class Scorer_02 {
    private final Candidate candidate;
    private final MedicalExam medicalExam;
    private final ScoringGuide scoringGuide;

    private int result = 0;
    private int healthLevel = 0;
    private boolean highMedicalRiskFlag = false;
    private String certificationGrade = "regular";

    public Scorer_02(Candidate candidate, MedicalExam medicalExam, ScoringGuide scoringGuide) {
        this.candidate = candidate;
        this.medicalExam = medicalExam;
        this.scoringGuide = scoringGuide;
    }

    public int execute() {
        assessMedicalRisk();
        assessCertification();
        penalizeHealthRisk();
        return result;
    }

    // 흡연 여부에 따른 건강 리스크 반영
    private void assessMedicalRisk() {
        if (medicalExam.isSmoker()) {
            healthLevel += 10;
            highMedicalRiskFlag = true;
        }
    }

    // 인증 등급이 낮은 출신 지역인지 판단하고 감점
    private void assessCertification() {
        if (scoringGuide.stateWithLowCertification(candidate.getOriginState())) {
            certificationGrade = "low";
            result -= 5;
        }
    }

    // 건강 위험이 기준을 초과한 만큼 감점
    private void penalizeHealthRisk() {
        result -= Math.max(healthLevel - 5, 0);
    }
}
