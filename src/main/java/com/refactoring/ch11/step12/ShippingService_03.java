package com.refactoring.ch11.step12;

/**
 * 11.12 오류 코드를 예외로 바꾸기(Replace Error Code with Exception)
 * 예외 클래스를 생성하여 오류코드 반환 대신에 예외 발생시킴.
 * 불명확한 오류 코드(-23)를 제거하고, 명확한 예외(NoShippingRulesException)를 사용함.
 * Object 반환 타입을 ShippingRules로 변경하여, 호출부에서 try-catch로 오류를 처리할 수 있도록 함.
 */
public class ShippingService_03 {
    private final CountryData countryData;

    public ShippingService_03(CountryData countryData) {
        this.countryData = countryData;
    }

    public ShippingRules localShippingRules(String country) {
        Object data = countryData.getShippingRules(country);
        if (data != null)
            return new ShippingRules(data);
        else
            throw new NoShippingRulesException("No shipping rules for country: " + country);    // 불명확한 오류 코드 제거.
    }

    public static void main(String[] args){
        ShippingService_03 service = new ShippingService_03(new CountryData());

        try {
            ShippingRules rules = service.localShippingRules("KR");  // 정상 국가 코드
            System.out.println("적용된 배송 규칙: " + rules.getRuleSummary());
        } catch(NoShippingRulesException e) {
            System.out.println("오류 발생: " + e.getMessage());
            return;
        }
    }
}
