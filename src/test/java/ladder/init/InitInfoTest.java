package ladder.init;

import ladder.strategy.PollCreateStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InitInfoTest {

    @Test
    void constructorTest() {
//        InitInfo initInfo = new InitInfo(Arrays.asList("1", "2"), 1, () -> true);

//        assertThat(initInfo).isNotNull();
    }

    @ParameterizedTest
    @MethodSource
    void constructorExceptionTest(final List<String> users, final int length, final PollCreateStrategy pollCreateStrategy) {
//        assertThatThrownBy(() -> new InitInfo(users, length, pollCreateStrategy)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream constructorExceptionTest() {
        PollCreateStrategy strategy = () -> true;
        return Stream.of(
                Arguments.of(null, 1, strategy),
                Arguments.of(Arrays.asList(), 1, strategy),
                Arguments.of(Arrays.asList("123"), 0, strategy),
                Arguments.of(Arrays.asList("123"), -1, strategy),
                Arguments.of(Arrays.asList("123"), 1, null)
        );
    }
}