package com.refactoring.ch11.step09;

public class Scorer {
    private Candidate candidate;
    private MedicalExam medicalExam;
    private ScoringGuide scoringGuide;

    private int result;
    private int healthLevel;
    private boolean highMedicalRiskFlag;
    private String certificationGrade;

    public Scorer(Candidate candidate, MedicalExam medicalExam, ScoringGuide scoringGuide) {
        this.candidate = candidate;
        this.medicalExam = medicalExam;
        this.scoringGuide = scoringGuide;
    }

    // 리팩터링 이전
//    public int execute() {
//        result = 0;
//        healthLevel = 0;
//        highMedicalRiskFlag = false;
//        certificationGrade = "regular";
//
//        if (medicalExam.isSmoker()) {
//            healthLevel += 10;
//            highMedicalRiskFlag = true;
//        }
//
//        if (scoringGuide.stateWithLowCertification(candidate.getOriginState())) {
//            certificationGrade = "low";
//            result -= 5;
//        }
//
//        result -= Math.max(healthLevel - 5, 0);
//
//        return result;
//    }

    // 리팩터링 이후
    public int execute() {
        initState();
        assessSmoking();
        assessCertification();
        applyHealthPenalty();
        return result;
    }

    private void initState() {
        result = 0;
        healthLevel = 0;
        highMedicalRiskFlag = false;
        certificationGrade = "regular";
    }

    private void assessSmoking() {
        if (medicalExam.isSmoker()) {
            healthLevel += 10;
            highMedicalRiskFlag = true;
        }
    }

    private void assessCertification() {
        if (scoringGuide.stateWithLowCertification(candidate.getOriginState())) {
            certificationGrade = "low";
            result -= 5;
        }
    }

    private void applyHealthPenalty() {
        result -= Math.max(healthLevel - 5, 0);
    }
}
