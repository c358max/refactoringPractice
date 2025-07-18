package com.refactoring.ch11.step12;

/**
 * 11.12 오류 코드를 예외로 바꾸기(Replace Error Code with Exception)
 */
public class ShippingService {
    private final CountryData countryData;

    public ShippingService(CountryData countryData) {
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
        ShippingService service = new ShippingService(new CountryData());

        try {
            ShippingRules rules = service.localShippingRules("KR");  // 정상 국가 코드
            System.out.println("적용된 배송 규칙: " + rules.getRuleSummary());
        } catch(NoShippingRulesException e) {
            System.out.println("오류 발생: " + e.getMessage());
            return;
        }
    }
}
