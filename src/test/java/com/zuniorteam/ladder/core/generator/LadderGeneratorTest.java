package com.zuniorteam.ladder.core.generator;

import com.zuniorteam.ladder.core.Line;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Ladder Generator Test")
class LadderGeneratorTest {

    @DisplayName("생성, 성공")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new LadderGenerator(Mockito.mock(LineGenerator.class)));
    }

    @DisplayName("생성, 실패, lineGenerator NULL 일 때")
    @Test
    void testNewInstance02() {
        assertThrows(AssertionError.class, () -> new LadderGenerator(null));
    }

    @DisplayName("Ladder Generate")
    @Test
    void testGenerate() {
        //given
        final int height = 4;
        final int lineLength = 5;
        final LadderGenerator ladderGenerator = new LadderGenerator(new LineGenerator());

        //when
        final List<Line> ladder = ladderGenerator.generate(lineLength, height);

        //then
        assertThat(ladder.size()).isEqualTo(height);
        assertThat(ladder)
                .extracting(Line::getLength)
                .containsExactly(lineLength, lineLength, lineLength, lineLength);
    }
}
