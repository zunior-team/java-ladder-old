package model.level;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("난이도는")
class LevelTest {

    @ParameterizedTest
    @MethodSource("provideStringLevel")
    @DisplayName("스트링에 맞는 레벨을 반환한다.")
    void getLevelByString(String level, Level expectedLevel) {
        // when
        final Level currentLevel = Level.getLevelByString(level);

        // then
        assertThat(currentLevel).isEqualTo(expectedLevel);
    }

    @ParameterizedTest
    @MethodSource("provideLevelAndHeight")
    @DisplayName("설정된 높이를 반환한다.")
    void getHeight(Level level, int expectedHeight) {
        // when
        final int currentHeight = level.getHeight();

        // then
        assertThat(currentHeight).isEqualTo(expectedHeight);
    }

    private static Stream<Arguments> provideStringLevel(){
        return Stream.of(
            Arguments.arguments("상", Level.HIGH),
            Arguments.arguments("중", Level.MEDIUM),
            Arguments.arguments("하", Level.LOW)
        );
    }

    private static Stream<Arguments> provideLevelAndHeight(){
        return Stream.of(
            Arguments.arguments(Level.HIGH, Level.Height.HIGH),
            Arguments.arguments(Level.MEDIUM, Level.Height.MEDIUM),
            Arguments.arguments(Level.LOW, Level.Height.LOW)
        );
    }
}