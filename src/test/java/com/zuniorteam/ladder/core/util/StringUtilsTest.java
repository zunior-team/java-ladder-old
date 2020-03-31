package com.zuniorteam.ladder.core.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringUtilsTest {

    @DisplayName("IsEmpty() 테스트, null 또는 empty ")
    @NullAndEmptySource
    @ValueSource(strings = {" ",  "  "})
    @ParameterizedTest
    void testIsEmpty01(String str){
        assertThat(StringUtils.isEmpty(str)).isTrue();
    }

    @DisplayName("IsEmpty() 테스트, 텍스트가 있을 때")
    @ValueSource(strings = {"A",  "B  "})
    @ParameterizedTest
    void testIsEmpty02(String str){
        assertThat(StringUtils.isEmpty(str)).isFalse();
    }

    @DisplayName("fillRest()")
    @ParameterizedTest
    @CsvSource(value = {"a, @, 5, a@@@@", "abc, #, 5, abc##", "abcde, #, 5, abcde"})
    void testFillRest(String base, char token, int length, String expected){
        assertThat(StringUtils.fillRest(base,token,length)).isEqualTo(expected);
    }



}
