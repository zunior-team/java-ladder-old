package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class RandomPointGenerator implements PointGenerator {

    public static final int HUNDREDS = 100;
    public static final int ZERO = 0;
    private final int randomPercentage;

    public RandomPointGenerator(int randomPercentage) {
        if (randomPercentage < ZERO || randomPercentage > HUNDREDS) {
            throw new IllegalArgumentException("입력값 : [" + randomPercentage + "] 이 " + ZERO + "보다 작거나, " + HUNDREDS + "보다 큽니다");
        }
        this.randomPercentage = randomPercentage;
    }

    @Override
    public List<Boolean> generate(int playerCount) {
        final List<Boolean> points = new ArrayList<>();

        points.add(ThreadLocalRandom.current().nextInt(HUNDREDS) < randomPercentage);
        while (points.size() != playerCount - 1) {
            points.add(nextRandomValue(points));
        }
        return points;
    }

    private boolean nextRandomValue(List<Boolean> points) {
        if (Objects.isNull(points) || points.isEmpty()) {
            throw new IllegalArgumentException("points can not be empty or null");
        }

        final int lastIndex = points.size() - 1;
        if (points.get(lastIndex)) {
            return false;
        }
        return ThreadLocalRandom.current().nextInt(HUNDREDS) < randomPercentage;
    }
}
