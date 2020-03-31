package com.zuniorteam.ladder.core.generator;

import com.zuniorteam.ladder.core.Line;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LineGenerator {

    private static final Random RANDOM = new Random();

    //TODO 알고리즘 필요.
    public Line newLine(int lineLength) {

        final List<Boolean> points = IntStream.range(0, lineLength)
                .mapToObj(i -> RANDOM.nextBoolean())
                .collect(toList());

        return new Line(points);
    }

}
