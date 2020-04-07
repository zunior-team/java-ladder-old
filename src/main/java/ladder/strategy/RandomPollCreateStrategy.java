package ladder.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class RandomPollCreateStrategy implements PollCreateStrategy {
    public static final int LIMIT = 10;
    public static final int STANDARD = 5;

    @Override
    public boolean isCreatable() {
        return ThreadLocalRandom.current()
                .nextInt(LIMIT) >= STANDARD;
    }
}
