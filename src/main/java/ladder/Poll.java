package ladder;

import ladder.strategy.PollCreateStrategy;

import java.util.function.Function;

public enum Poll {
    RIGHT(x -> x + 1),
    LEFT(x -> x - 1),
    NONE(x -> x);

    private final Function<Integer, Integer> calculator;

    Poll(Function<Integer, Integer> calculator) {
        this.calculator = calculator;
    }

    public int move(int position) {
        return calculator.apply(position);
    }

    public Poll nextPoll(PollCreateStrategy pollCreateStrategy) {
        if(this == RIGHT) {
            return LEFT;
        }

        return pollCreateStrategy.isCreatable() ? RIGHT : NONE;
    }

    public boolean hasPoll() {
        return this == RIGHT;
    }
}
