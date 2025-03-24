package com.refactoring.ch01;

import com.fasterxml.jackson.core.type.TypeReference;
import com.refactoring.dataloader.DataLoader;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StatementTest {
    private Statement statement;

    @Test
    void statement() {
        statement = new Statement();

        // given
        List<Invoice> invoices = DataLoader.loadJsonData(getClass(), "invoices.json", new TypeReference<>() {});
        Map<String, Play> plays = DataLoader.loadJsonData(getClass(), "plays.json", new TypeReference<>() {});
        Invoice invoice = invoices.get(0);

        final String expected = """
                청구 내역 (고객명: BigCo)
                  Hamlet: ₩65,000 (55석)
                  As You Like It: ₩58,000 (35석)
                  Othello: ₩50,000 (40석)
                총액: ₩173,000
                적립 포인트: 47점
                """;

        // when
        Statement stat = new Statement();
        String result = stat.statement(invoice, plays);

        // then
        assertThat(result).isEqualTo(expected);
    }

}
