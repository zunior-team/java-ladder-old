package com.zuniorteam.ladder.core.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("Line Generator")
class LineGeneratorTest {


    @DisplayName("생성, 성공")
    @Test
    void newInstance01(){
        assertDoesNotThrow(() -> new LineGenerator());
    }

}
