package com.refactoring.ch11.step09;

public class MedicalExam {
    private boolean smoker;

    public MedicalExam(boolean smoker) {
        this.smoker = smoker;
    }

    // 흡연여부
    public boolean isSmoker() {
        return smoker;
    }
}
