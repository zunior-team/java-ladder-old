package ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LadderDifficulty {
    HIGH("상", LadderHeight.HIGH, new RandomPointGenerator(RandomPercentage.HIGH)),
    MEDIUM("중", LadderHeight.MEDIUM, new RandomPointGenerator(RandomPercentage.MEDIUM)),
    LOW("하", LadderHeight.LOW, new RandomPointGenerator(RandomPercentage.LOW));

    private static final Map<String, LadderDifficulty> inputs = Collections.unmodifiableMap(
            Stream.of(values())
                    .collect(Collectors.toMap(LadderDifficulty::getInput, Function.identity()))
    );

    private final String input;
    private final int height;
    private final PointGenerator pointGenerator;

    LadderDifficulty(String input, int height, PointGenerator pointGenerator) {
        this.input = input;
        this.height = height;
        this.pointGenerator = pointGenerator;
    }

    public static LadderDifficulty findByInput(String input) {
        final LadderDifficulty difficulty = inputs.get(input);

        if (Objects.isNull(difficulty) || Objects.isNull(input)) {
            throw new IllegalArgumentException("입력 : [" + input + "] 이 올바르지 않습니다. 입력값을 확인해주세요.");
        }

        return difficulty;
    }

    public int getHeight() {
        return height;
    }

    public PointGenerator getPointGenerator() {
        return pointGenerator;
    }

    public String getInput() {
        return input;
    }


    private static class LadderHeight {
        public static final int HIGH = 20;
        public static final int MEDIUM = 10;
        public static final int LOW = 5;
    }

    private static class RandomPercentage {
        public static final int HIGH = 75;
        public static final int MEDIUM = 50;
        public static final int LOW = 30;
    }
}
