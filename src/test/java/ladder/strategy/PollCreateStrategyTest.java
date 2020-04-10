package ladder.strategy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PollCreateStrategyTest {
    PollCreateStrategy pollCreateStrategy = mock(PollCreateStrategy.class);

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void pollCreateStrategyTest(boolean bool) {
        when(pollCreateStrategy.isCreatable())
                .thenReturn(bool);

        assertThat(pollCreateStrategy.isCreatable()).isEqualTo(bool);
    }
}