package com.zuniorteam.ladder.core.generator;

import com.zuniorteam.ladder.core.Line;

import java.util.ArrayList;
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

    public Line generate(int numberOfBridges) {
        final List<Boolean> randomBridges = getRandomBridges(numberOfBridges);

        return new Line(fixBridges(randomBridges));
    }

    private List<Boolean> getRandomBridges(int lineLength) {
        final List<Boolean> randomBridges = IntStream.range(0, lineLength)
                .mapToObj(i -> random.nextBoolean())
                .collect(toList());

        return IntStream.range(1, randomBridges.size())
                .mapToObj(i -> randomBridges.get(i - 1) && randomBridges.get(i))
                .collect(toList());
    }

    private List<Boolean> fixBridges(List<Boolean> randomBridges) {
        final ArrayList<Boolean> fixBridges = new ArrayList<>(randomBridges);

        IntStream.range(0, fixBridges.size())
                .forEach(index -> fixBridges.set(index, fixBridge(fixBridges, index)));

        return fixBridges;
    }

    private boolean fixBridge(List<Boolean> bridges, int index) {
        if (index < 1) {
            return bridges.get(index);
        }

        if (bridges.get(index) && bridges.get(index - 1)) {
            return false;
        }

        return bridges.get(index);
    }

}
