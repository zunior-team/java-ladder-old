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
    void testGenerate01() {
        //given
        final Random random = Mockito.mock(Random.class);
        given(random.nextBoolean()).willReturn(true);

        final LineGenerator lineGenerator = new LineGenerator(random);

        //when, then
        assertDoesNotThrow(() -> lineGenerator.generate(100, 1));
    }

    @DisplayName("Line generate, 확률이 100% 일때")
    @Test
    void testGenerate02() {
        //given
        final int numberOfPoint = 10;
        final int numberOfBridge = numberOfPoint - 1;

        final LineGenerator lineGenerator = new LineGenerator(new Random());

        //when
        final Line line = lineGenerator.generate(numberOfPoint, 1);

        //then
        for (int i = 0; i < numberOfBridge; i += 2) {
            assertThat(line.hasBridge(i)).isTrue();
        }

        for (int i = 1; i < numberOfBridge; i += 2) {
            assertThat(line.hasBridge(i)).isFalse();
        }
    }

    @DisplayName("Line generate, 확률이 0% 일때")
    @Test
    void testGenerate03() {
        //given
        final int numberOfPoint = 10;
        final int numberOfBridge = numberOfPoint - 1;

        final LineGenerator lineGenerator = new LineGenerator(new Random());

        //when
        final Line line = lineGenerator.generate(numberOfPoint, 0);

        //then
        for (int i = 0; i < numberOfBridge; i++) {
            assertThat(line.hasBridge(i)).isFalse();
        }

    }
}
