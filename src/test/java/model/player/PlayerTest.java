package model.player;

import exception.PlayersCreateException;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("플레이어는")
class PlayerTest {



    @DisplayName("생성시 에러가 발생한다.")
    @MethodSource("provideName")
    @ParameterizedTest
    void createExceptionTest(String name) {
        // when & then
        assertThatThrownBy(() -> Player.create(name))
                .isInstanceOf(PlayersCreateException.class);
    }

    private static Stream<Arguments> provideName(){
        return Stream.of(
            Arguments.arguments((Object) null),
            Arguments.arguments(StringUtils.EMPTY),
            Arguments.arguments("PARKS")
        );
    }
}
