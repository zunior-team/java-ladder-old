package com.zuniorteam.ladder.core.generator;

import com.zuniorteam.ladder.core.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@DisplayName("Line Generator")
class LineGeneratorTest {


    @DisplayName("생성, 성공")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new LineGenerator(new Random()));
    }

    @DisplayName("생성, 실패 null값이 주입됬을 때")
    @Test
    void testNewInstance02() {
        assertThrows(AssertionError.class, () -> new LineGenerator(null));
    }

    @DisplayName("Line generate")
    @Test
    void testGenerate() {
        //given
        final Random random = Mockito.mock(Random.class);
        given(random.nextBoolean()).willReturn(true);

        final LineGenerator lineGenerator = new LineGenerator(random);

        //when, then
        assertDoesNotThrow(() -> lineGenerator.generate(100));
    }
}
