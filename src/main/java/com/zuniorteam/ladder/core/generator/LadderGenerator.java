package com.zuniorteam.ladder.core.generator;

import com.sun.javafx.iio.ios.IosImageLoader;
import com.zuniorteam.ladder.core.Ladder;
import com.zuniorteam.ladder.core.LadderLevel;
import com.zuniorteam.ladder.core.Line;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {

    private final LineGenerator lineGenerator;

    public LadderGenerator(LineGenerator lineGenerator) {
        assert lineGenerator != null;

        this.lineGenerator = lineGenerator;
    }

    public Ladder generate(int numberOfPoints, LadderLevel ladderLevel) {

        if(Objects.isNull(ladderLevel)){
            throw new IllegalArgumentException("사다리 게임 레벨이 없습니다");
        }

        List<Line> lines = IntStream.range(0, ladderLevel.getLadderHeight())
                .mapToObj(i -> lineGenerator.generate(numberOfPoints, ladderLevel.getPercentOfBuildBridge()))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

}
