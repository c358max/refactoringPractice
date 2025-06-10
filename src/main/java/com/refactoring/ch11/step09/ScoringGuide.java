package com.refactoring.ch11.step09;

import java.util.Set;

public class ScoringGuide {
    // 저등급 지역코드
    private static final Set<String> LOW_CERTIFICATION_STATES = Set.of("FL", "TX", "NV");

    public boolean stateWithLowCertification(String stateCode) {
        return LOW_CERTIFICATION_STATES.contains(stateCode);
    }
}
