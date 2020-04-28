package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderDifficultyTest {

    @DisplayName("난이도 값이 입력되면 해당하는 입력값으 LadderDifficulty를 찾는다")
    @ParameterizedTest
    @ValueSource(strings = {"상", "중", "하"})
    void testFindByInput(String input) {
        final LadderDifficulty ladderDifficulty = LadderDifficulty.findByInput(input);
        assertThat(ladderDifficulty)
                .isNotNull()
                .isOfAnyClassIn(LadderDifficulty.class);
    }
    @DisplayName("존재하지 않는 난이도 값이 입력되면 Exception을 던진다")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"호호", "중ㅈ", "하ㅁ"})
    void testFindByInputExceptions(String input) {
        assertThrows(IllegalArgumentException.class, () -> LadderDifficulty.findByInput(input));
    }
}