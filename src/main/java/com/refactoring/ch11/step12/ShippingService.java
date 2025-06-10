package com.refactoring.ch11.step12;

public class ShippingService {
    public Object localShippingRules(String country) {
        Object data = CountryData.getShippingRules(country);
        if (data != null) {
            return new ShippingRules(data);
        } else {
            return -23;  // 에러 코드
        }
    }
}
