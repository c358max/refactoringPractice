package com.refactoring.ch11.step12;

/**
 * 11.12 오류 코드를 예외로 바꾸기(Replace Error Code with Exception)
 * 리팩터링 전 : -23이라는 매직 넘버가 오류 코드로 사용됨. 무슨 의미인지 알기 어려움.
 * 오류 발생시 호출자가 if 문을 강제로 작성해야 함.
 * null 이나 숫자 오류 코드는 실수로 무시되거나 로직이 꼬일 수 있음.
 * 오류 발생시 숫자형 코드를 반환하지 않고 예외(Exception)를 던져서 오류 처리 흐름을 명확하게 만드는게 목적임. (예외처리 강제화)
 */
public class ShippingService_01 {
    private final CountryData countryData;

    public ShippingService_01(CountryData countryData) {
        this.countryData = countryData;
    }

    //
    public Object localShippingRules(String country) {
        Object data = countryData.getShippingRules(country);
        if (data != null)
            return new ShippingRules(data);
        else
            return -23;
    }

    public static void main(String[] args){
        ShippingService_01 service = new ShippingService_01(new CountryData());

        Object result = service.localShippingRules("KR");  // 정상 국가 코드

        if (result instanceof Integer && ((int) result) == -23) {
            System.out.println("오류 발생: 국가 정보를 찾을 수 없음");
        } else {
            ShippingRules rules = (ShippingRules) result;
            System.out.println("적용된 배송 규칙: " + rules.getRuleSummary());
        }
    }
}
