package com.refactoring.ch11.step09;

/**
 * 11.9 함수를 명령으로 바꾸기(Replace Function with Command)
 * ScoreService에 있는 계산로직을 Score 클래스로 분리
 * ScoreService에서는 Score의 execute() 메서드를 호출하여 점수를 계산
 */
public class Scorer_01 {
    private final Candidate candidate;
    private final MedicalExam medicalExam;
    private final ScoringGuide scoringGuide;

    private int result = 0;
    private int healthLevel = 0;
    private boolean highMedicalRiskFlag = false;
    private String certificationGrade = "regular";

    public Scorer_01(Candidate candidate, MedicalExam medicalExam, ScoringGuide scoringGuide) {
        this.candidate = candidate;
        this.medicalExam = medicalExam;
        this.scoringGuide = scoringGuide;
    }

    public int execute() {
        // 흡연자인 경우 건강 위험도 증가 및 건강 위험 플래그 설정
        if (medicalExam.isSmoker()) {
            healthLevel += 10;
            highMedicalRiskFlag = true;     // 건강 위험 상태 플래그 설정
        }

        // 인증 등급이 낮은 출신 지역일 경우 점수 감점
        if (scoringGuide.stateWithLowCertification(candidate.getOriginState())) {
            certificationGrade = "low";
            result -= 5;
        }

        // 건강 위험도가 5를 초과한 만큼 감점
        result -= Math.max(healthLevel - 5, 0);
        return result;
    }
}
