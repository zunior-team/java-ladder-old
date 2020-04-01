package com.zuniorteam.ladder.core.generator;

import com.zuniorteam.ladder.core.Line;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LineGenerator {

    private final Random random;

    public LineGenerator(Random random) {
        assert random != null;

        this.random = random;
    }

    public Line generate(int lineLength) {
        final List<Boolean> randomPoints = IntStream.range(0, lineLength)
                .mapToObj(i -> random.nextBoolean())
                .collect(toList());

        return new Line(fixPoints(randomPoints));
    }

    private List<Boolean> fixPoints(List<Boolean> randomPoints) {
        return IntStream.range(0, randomPoints.size())
                .mapToObj(index -> fixContinues(randomPoints, index))
                .collect(toList());
    }

    private boolean fixContinues(List<Boolean> points, int index) {
        if (index < 2) {
            return points.get(index);
        }

        if (points.get(index - 1) && points.get(index - 2)) {
            return false;
        }

        return points.get(index);
    }

}
