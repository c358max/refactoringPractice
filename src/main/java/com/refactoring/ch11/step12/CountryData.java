package com.refactoring.ch11.step12;

import java.util.HashMap;
import java.util.Map;

public class CountryData {
    private static final Map<String, Object> shippingRulesMap = new HashMap<>();

    static {
        // 샘플 데이터 초기화
        shippingRulesMap.put("KR", "Korea Shipping Rule");
        shippingRulesMap.put("US", "US Shipping Rule");
        shippingRulesMap.put("JP", "Japan Shipping Rule");
    }

    public static Object getShippingRules(String countryCode) {
        return shippingRulesMap.get(countryCode);
    }
}
