package ladder;

import ladder.init.InitInfo;
import ladder.strategy.PollCreateStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BlockTest {


    @ParameterizedTest
    @MethodSource
    void constructorTest(List<String> users, PollCreateStrategy pollCreateStrategy, boolean evenExpected, boolean oddExpected) {
        Block block = new Block(new InitInfo(users, 0, pollCreateStrategy));

        IntStream.rangeClosed(0, users.size())
                .forEach(i -> assertThat(block.hasRightLadder(i)).isEqualTo(i % 2 == 0 ? evenExpected : oddExpected));
    }

    private static Stream constructorTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("n", "o", "k", "c", "h", "a", "x"), (PollCreateStrategy) () -> true, true, false),
                Arguments.of(Arrays.asList("n", "o", "k", "c", "h", "a", "x"), (PollCreateStrategy) () -> false, false, false)
        );
    }
}