package model.ladder;

import exception.LadderResultCreateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("스코어 타입은")
class ScoreTypeTest {

    @ParameterizedTest
    @MethodSource("provideMyScore")
    @DisplayName("나의 현재 스코어 타입을 반환한다.")
    public void getMyScoreTypeTest(String result, ScoreType expectedScoreType){
        // when
        final ScoreType myScoreType = ScoreType.getMyScoreType(result);

        // https://stackoverflow.com/questions/5535777/what-is-the-difference-between-issameas-and-isequalto-in-fest
        // then
        assertThat(myScoreType).isSameAs(expectedScoreType);
    }

    private static Stream<Arguments> provideMyScore(){
        return Stream.of(
            Arguments.of("꽝", ScoreType.FAIL),
            Arguments.of("5000", ScoreType.POINT),
            Arguments.of("10000", ScoreType.POINT)
        );
    }

    @ParameterizedTest
    @CsvSource({
        "꽝1",
        "꽝2",
        "당첨",
        "-1",
    })
    @DisplayName("나의 현재 스코어 타입을 반환하다 에러가 발생한다.")
    public void getMyScoreTypeExceptionTest(String result){

        assertThatThrownBy(() -> ScoreType.getMyScoreType(result))
                .isInstanceOf(LadderResultCreateException.class);
    }
}
