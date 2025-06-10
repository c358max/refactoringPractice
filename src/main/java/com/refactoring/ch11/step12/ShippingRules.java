package com.refactoring.ch11.step12;

public class ShippingRules {
    private Object rawData;

    public ShippingRules(Object data) {
        this.rawData = data;
    }

    public String getRuleSummary() {
        return rawData.toString();  // 실제로는 필드에서 정보 추출
    }
}
