package ladder.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class ComplexityPollCreateStrategy implements PollCreateStrategy {
    private static final int LIMIT = 10;
    private final Complexity complexity;

    public ComplexityPollCreateStrategy(Complexity complexity) {
        this.complexity = complexity;
    }

    @Override
    public boolean isCreatable() {
        return ThreadLocalRandom.current()
                .nextInt(LIMIT) >= complexity.getStandard();
    }
}
