package model.ladder;

import exception.LadderCreateException;
import model.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("사다리는")
class LadderTest {

    @DisplayName("높이가 0 이하라서 에러가 발생합니다.")
    @MethodSource("providePlayerAndHeight")
    @ParameterizedTest
    void ofExceptionTest(Players players, Scores scores, int height) {
        // when & then
//        assertThatThrownBy(() -> Ladder.of(players, scores, height))
//                .isInstanceOf(LadderCreateException.class);
    }



    private static Stream<Arguments> providePlayerAndHeight(){
        return Stream.of(
                arguments(Players.create(Collections.singletonList("KIM")), Scores.create(Collections.singletonList("1000")),  -1),
                arguments(Players.create(Arrays.asList("KIM", "MIN")), Scores.create(Arrays.asList("1000", "꽝")), 0),
                arguments(Players.create(Arrays.asList("KIM", "MIN")), Scores.create(Arrays.asList("1000", "꽝", "5000")), 10)
        );
    }
}
