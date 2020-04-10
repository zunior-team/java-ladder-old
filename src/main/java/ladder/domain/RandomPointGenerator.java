package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RandomPointGenerator implements PointGenerator {

    private final Random random;

    public RandomPointGenerator(Random random) {
        Objects.requireNonNull(random, "random can not be null");
        this.random = random;
    }

    @Override
    public List<Boolean> generate(int playerCount) {
        final List<Boolean> points = new ArrayList<>();

        points.add(random.nextBoolean());
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
        return random.nextBoolean();
    }
}
