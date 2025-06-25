package com.refactoring.ch11.step12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShippingServiceTest {
    @DisplayName("국가코드 KO인 경우, 배송 규칙을 반환한다")
    @Test
    void testKoreaReturnsShippingRules() {
        ShippingService service = new ShippingService(new CountryData());

        ShippingRules rules = service.localShippingRules("KR");
        assertEquals("Korea Shipping Rule", rules.getRuleSummary());
    }

    @DisplayName("국가코드 US인 경우, 배송 규칙을 반환한다")
    @Test
    void testUnitedStateReturnsShippingRules() {
        ShippingService service = new ShippingService(new CountryData());

        ShippingRules rules = service.localShippingRules("US");
        assertEquals("United State Shipping Rule", rules.getRuleSummary());
    }

    @DisplayName("국가코드 JP인 경우, 배송 규칙을 반환한다")
    @Test
    void testJapanReturnsShippingRules() {
        ShippingService service = new ShippingService(new CountryData());

        ShippingRules rules = service.localShippingRules("JP");
        assertEquals("Japan Shipping Rule", rules.getRuleSummary());
    }

    @DisplayName("존재하지 않는 국가 코드일 경우, NoShippingRulesException 예외를 던진다")
    @Test
    void testInvalidCountryThrowsException() {
        ShippingService service = new ShippingService(new CountryData());

        assertThrows(NoShippingRulesException.class, () -> {
            service.localShippingRules("XXX");
        });
    }
}