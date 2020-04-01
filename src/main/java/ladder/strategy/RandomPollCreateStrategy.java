package ladder.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class RandomPollCreateStrategy implements PollCreateStrategy {
    @Override
    public boolean decideCreateOrNot() {
        return ThreadLocalRandom.current()
                .nextInt(10) >= 5;
    }
}
