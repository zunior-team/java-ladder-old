package com.zuniorteam.ladder.core.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringUtilTest {

    @DisplayName("IsEmpty() 테스트, null 또는 empty ")
    @NullAndEmptySource
    @ValueSource(strings = {" ",  "  "})
    @ParameterizedTest
    void testIsEmptyIfBlank(String str){
        assertThat(StringUtil.isEmpty(str)).isTrue();
    }

    @DisplayName("IsEmpty() 테스트, 텍스트가 있을 때")
    @ValueSource(strings = {"A",  "B  "})
    @ParameterizedTest
    void testIsEmptyIfNotEmpty(String str){
        assertThat(StringUtil.isEmpty(str)).isFalse();
    }

    @DisplayName("fill Test")
    @ParameterizedTest
    @CsvSource(value = {"a, @, 5, a@@@@", "abc, #, 5, abc##", "abcde, #, 5, abcde"})
    void testFillRest(String base, char token, int length, String expected){
        assertThat(StringUtil.fill(base,token,length)).isEqualTo(expected);
    }



}
