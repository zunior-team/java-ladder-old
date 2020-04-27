package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Player 테스트")
class PlayerTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("플레이어의 이름은 NULL 혹은 빈값이 들어올 수 없다")
    void testNullAndEmpty(String name) {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Player(name));

        assertThat(exception).hasMessage("name : " + name + " 은 비거나 NULL 값이 들어올 수 없습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"all"})
    @DisplayName("플레이어의 이름에 예약어는 들어올 수 없다")
    void testReservedWords(String name) {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Player(name));

        assertThat(exception).hasMessage("예약어 : " + name + " 은 사용할 수 없는 이름 입니다");
    }

}