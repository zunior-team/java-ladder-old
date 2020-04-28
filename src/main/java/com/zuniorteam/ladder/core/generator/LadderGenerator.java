package com.zuniorteam.ladder.core.generator;

import com.zuniorteam.ladder.core.Ladder;
import com.zuniorteam.ladder.core.Line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {

    private final LineGenerator lineGenerator;

    public LadderGenerator(LineGenerator lineGenerator) {
        assert lineGenerator != null;

        this.lineGenerator = lineGenerator;
    }

    public Ladder generate(int numberOfPoints, int height) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> lineGenerator.generate(numberOfPoints))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

}
