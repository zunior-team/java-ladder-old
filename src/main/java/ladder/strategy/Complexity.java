package ladder.strategy;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Complexity {
    LOW("하", 9, 4, 1),
    MEDIUM("중", 7, 7, 4),
    HIGH("상", 5, 10, 7);

    private static final Map<String, Complexity> COMPLEXITIES = Arrays.stream(Complexity.values())
            .collect(Collectors.toMap(Complexity::getComplexity, Function.identity()));

    private final String complexity;
    private final int standard;
    private final int highLimit;
    private final int lowLimit;

    Complexity(String inputComplexity, int standard, int highLimit, int lowLimit) {
        this.complexity = inputComplexity;
        this.standard = standard;
        this.highLimit = highLimit;
        this.lowLimit = lowLimit;
    }

    private String getComplexity() {
        return complexity;
    }

    public int getStandard() {
        return this.standard;
    }

    public static Complexity of(String inputComplexity) {
        if(!COMPLEXITIES.containsKey(inputComplexity)) {
            throw new IllegalArgumentException("Invalid complexity input type : " + inputComplexity);
        }

        return COMPLEXITIES.get(inputComplexity);
    }

    public int getHeight() {
        return ThreadLocalRandom.current()
                .nextInt(lowLimit, highLimit);
    }
}
