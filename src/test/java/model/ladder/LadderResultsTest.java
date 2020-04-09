package model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("사다리 타기 결과는")
class LadderResultsTest {

    @DisplayName("생성된다.")
    @MethodSource("provideLadderResult")
    @ParameterizedTest
    void createTest(List<String> results) {

        // when
        LadderResults ladderResults = LadderResults.create(results);

        // then
        assertNotNull(ladderResults);
    }

    private static Stream<Arguments> provideLadderResult(){
        return Stream.of(
            Arguments.of(Arrays.asList("꽝", "5000", "3000", "꽝"))
        );
    }
}
