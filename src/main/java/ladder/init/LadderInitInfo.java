package ladder.init;

import ladder.strategy.PollCreateStrategy;

public class LadderInitInfo {
    private int height;
    private PollCreateStrategy pollCreateStrategy;

    public LadderInitInfo(final int height, final PollCreateStrategy pollCreateStrategy) {
        validate(height, pollCreateStrategy);
        this.height = height;
        this.pollCreateStrategy = pollCreateStrategy;
    }

    private void validate(final int length, final PollCreateStrategy pollCreateStrategy) {
        validateLength(length);
        validateStrategy(pollCreateStrategy);
    }

    private void validateStrategy(PollCreateStrategy pollCreateStrategy) {
        if(pollCreateStrategy == null) {
            throw new IllegalArgumentException("PollCreateStrategy can't be a null");
        }
    }

    private void validateLength(int length) {
        if(length < 1) {
            throw new IllegalArgumentException("Ladder can't be created with length : " + length);
        }
    }

    public int getHeight() {
        return height;
    }

    public PollCreateStrategy getPollCreateStrategy() {
        return pollCreateStrategy;
    }
}
