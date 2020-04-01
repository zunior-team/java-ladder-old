package ladder;

import ladder.strategy.PollCreateStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PollTest {

    @ParameterizedTest
    @MethodSource
    void initTest(PollCreateStrategy pollCreateStrategy) {
        Poll poll = Poll.init(pollCreateStrategy);

        assertThat(poll).isNotNull();
        assertThat(poll.isExist()).isEqualTo(pollCreateStrategy.decideCreateOrNot());
    }

    private static Stream initTest() {
        return Stream.of(
                Arguments.of((PollCreateStrategy) () -> true),
                Arguments.of((PollCreateStrategy)() -> false)
        );
    }
}