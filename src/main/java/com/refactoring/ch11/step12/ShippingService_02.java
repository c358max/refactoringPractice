package com.refactoring.ch11.step12;

/**
 * 11.12 오류 코드를 예외로 바꾸기(Replace Error Code with Exception)
 * 매직넘버(-23) 상수로 치환
 */
public class ShippingService_02 {
    private final CountryData countryData;

    private static final int NO_SHIPPING_RULES = -23;

    public ShippingService_02(CountryData countryData) {
        this.countryData = countryData;
    }

    // 매직넘버를 상수로 치환
    public Object localShippingRules(String country) {
        Object data = countryData.getShippingRules(country);
        if (data != null)
            return new ShippingRules(data);
        else
            return NO_SHIPPING_RULES;
    }

    public static void main(String[] args){
        ShippingService_02 service = new ShippingService_02(new CountryData());

        Object result = service.localShippingRules("KR");  // 정상 국가 코드

        if (result instanceof Integer && ((int) result) == NO_SHIPPING_RULES) {
            System.out.println("오류 발생: 국가 정보를 찾을 수 없음");
        } else {
            ShippingRules rules = (ShippingRules) result;
            System.out.println("적용된 배송 규칙: " + rules.getRuleSummary());
        }
    }
}
