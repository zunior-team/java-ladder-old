package com.zuniorteam.ladder.core.generator;

import com.zuniorteam.ladder.core.Ladder;
import com.zuniorteam.ladder.core.LadderLevel;
import com.zuniorteam.ladder.core.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Random;

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
        final int numberOfPoints = 5;
        final LadderLevel ladderLevel = LadderLevel.HIGH;
        final LadderGenerator ladderGenerator = new LadderGenerator(new LineGenerator(new Random()));

        //when
        final Ladder ladder = ladderGenerator.generate(numberOfPoints, ladderLevel);

        //then
        final List<Line> lines = ladder.getLines();
        assertThat(lines.size()).isEqualTo(ladderLevel.getLadderHeight());
        assertThat(lines.get(0))
                .extracting(Line::getLength)
                .isEqualTo(numberOfPoints - 1);
    }
}
