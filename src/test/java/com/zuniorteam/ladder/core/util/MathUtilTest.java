package com.zuniorteam.ladder.core.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathUtilTest {

    @DisplayName("나누기")
    @ParameterizedTest
    @CsvSource({"1,1,1", "2,1,2", "1,2,0.5", "0,100,0"})
    void testDivide01(int x, int y, double expect) {
        assertThat(MathUtil.divide(x, y)).isEqualTo(expect);
    }

    @DisplayName("나누기, 분모가 0일 때")
    @Test
    void testDivide02() {
        assertThrows(IllegalArgumentException.class, () -> MathUtil.divide(0, 0));
    }

}
