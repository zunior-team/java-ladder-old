package ladder;

import java.util.function.Function;

public enum Direction {
    RIGHT(x -> x + 1),
    LEFT(x -> x - 1),
    NONE(x -> x);

    private final Function<Integer, Integer> calculator;

    Direction(Function<Integer, Integer> calculator) {
        this.calculator = calculator;
    }

    public int move(int position) {
        return calculator.apply(position);
    }
}
