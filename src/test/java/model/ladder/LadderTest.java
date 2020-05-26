package model.ladder;

import dto.LadderCreateDto;
import exception.LadderCreateException;
import model.level.Level;
import model.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리는")
class LadderTest {

    @DisplayName("높이가 0 이하라서 에러가 발생합니다.")
    @MethodSource("providePlayerAndHeight")
    @ParameterizedTest
    void ofExceptionTest(LadderCreateDto createDto) {
        // when & then
        assertThatThrownBy(() -> Ladder.of(createDto))
                .isInstanceOf(LadderCreateException.class);
    }



    private static Stream<Arguments> providePlayerAndHeight(){
        return Stream.of(Arguments.of(new LadderCreateDto(
                Players.create(Collections.singletonList("KIM")),
                Scores.create(Arrays.asList("1000", "2000")),
                Level.HIGH))
        );
    }
}
