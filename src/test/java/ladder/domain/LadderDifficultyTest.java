package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LadderDifficulty Test")
class LadderDifficultyTest {

    @DisplayName("난이도를 입력받아 LadderDifficulty 를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"상","중","하"})
    void of(String difficulty) {
        LadderDifficulty ladderDifficulty = LadderDifficulty.of(difficulty);
        assertThat(ladderDifficulty).isNotNull();
    }
    @DisplayName("난이도는 상 중 하 이어야만 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"싱","증","히"})
    void ofException(String difficulty){
        assertThatThrownBy(()-> LadderDifficulty.of(difficulty))
                .isInstanceOf(IllegalArgumentException.class);
    }
}