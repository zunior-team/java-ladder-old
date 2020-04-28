package com.zuniorteam.ladder.view.mapper;

import com.zuniorteam.ladder.core.LadderLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderLevelParserTest {

    @DisplayName("키워드로 파싱")
    @Test
    void testOfKeyword01(){
        assertThat(LadderLevelParser.parse("상")).isEqualTo(LadderLevel.HIGH);
        assertThat(LadderLevelParser.parse("중")).isEqualTo(LadderLevel.MEDIUM);
        assertThat(LadderLevelParser.parse("하")).isEqualTo(LadderLevel.LOW);
    }

    @DisplayName("키워드로 파싱, 실패")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "알수없으으으ㅡ으ㅡㅡㅡㅡㅡㅡㅡ")
    void testOfKeyword02(String keyword){
        assertThrows(IllegalArgumentException.class, () -> LadderLevelParser.parse(keyword));
    }

}
