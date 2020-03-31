package model.ladder;

import exception.LadderCreateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리는")
class LadderTest {

    @DisplayName("높이가 0 이하라서 에러가 발생합니다.")
    @ParameterizedTest
    @CsvSource({
        "0",
        "-1"
    })
    void ofExceptionTest(int height) {
        // when & then
        assertThatThrownBy(() -> Ladder.of(height))
                .isInstanceOf(LadderCreateException.class);
    }
}
