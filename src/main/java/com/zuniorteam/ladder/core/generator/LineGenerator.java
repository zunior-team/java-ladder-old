package com.zuniorteam.ladder.core.generator;

import com.zuniorteam.ladder.core.Line;
import com.zuniorteam.ladder.core.util.CollectionUtil;

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

    public Line generate(int numberOfPoints, double percentOfBuildBridge) {
        final List<Boolean> randomBridge = getRandomBridges(numberOfPoints, percentOfBuildBridge);

        return new Line(fixBridges(randomBridge));
    }

    private List<Boolean> getRandomBridges(int numberOfPoints, double percentOfBuildBridge) {
        final List<Boolean> randomPoints = IntStream.range(0, numberOfPoints)
                .mapToObj(i -> random.nextDouble() < percentOfBuildBridge)
                .collect(toList());

        return IntStream.range(1, randomPoints.size())
                .mapToObj(i -> CollectionUtil.getBefore(randomPoints, i) && randomPoints.get(i))
                .collect(toList());
    }

    private List<Boolean> fixBridges(List<Boolean> randomBridges) {
        final ArrayList<Boolean> fixBridges = new ArrayList<>(randomBridges);

        IntStream.range(0, fixBridges.size())
                .forEach(index -> fixBridges.set(index, fixBridge(fixBridges, index)));

        return fixBridges;
    }

    private boolean fixBridge(List<Boolean> bridges, int index) {
        if (CollectionUtil.isFirstIndex(index)) {
            return bridges.get(index);
        }

        if (bridges.get(index) && CollectionUtil.getBefore(bridges, index)) {
            return false;
        }

        return bridges.get(index);
    }

}
