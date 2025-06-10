package com.refactoring.ch11.step12;

public class Main {

    public static void main(String[] args) {
        ShippingService service = new ShippingService();

        String countryCode = "KR";  // "CN"일 경우 -23 반환됨

        Object result = service.localShippingRules(countryCode);

        if (result instanceof Integer && (Integer) result == -23) {
            System.err.println("배송 정책을 찾을 수 없습니다: " + countryCode);
        } else {
            ShippingRules rules = (ShippingRules) result;
            System.out.println("배송 규칙 정보: " + rules.getRuleSummary());
        }
    }
}
