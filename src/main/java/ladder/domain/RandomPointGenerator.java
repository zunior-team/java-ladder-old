package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class RandomPointGenerator implements PointGenerator {

    public RandomPointGenerator() {
    }

    @Override
    public List<Boolean> generate(int playerCount) {
        final List<Boolean> points = new ArrayList<>();

        points.add(randomValue());
        while (points.size() != playerCount - 1) {
            points.add(nextRandomValue(points));
        }
        return points;
    }

    protected abstract Boolean randomValue();

    private boolean nextRandomValue(List<Boolean> points) {
        if (Objects.isNull(points) || points.isEmpty()) {
            throw new IllegalArgumentException("points can not be empty or null");
        }

        final int lastIndex = points.size() - 1;
        if (points.get(lastIndex)) {
            return false;
        }
        return randomValue();
    }
}
