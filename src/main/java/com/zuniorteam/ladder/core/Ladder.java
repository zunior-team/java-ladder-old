package com.zuniorteam.ladder.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validate(lines);

        this.lines = lines;
    }

    private void validate(List<Line> lines) {
        assert lines != null;

        if(lines.isEmpty()){
            throw new IllegalArgumentException("사다리는 최소 1개의 라인을 가져야 합니다");
        }
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }

    public Map<User, String> play(List<User> users, List<String> results) {
        final Map<User, String> userToResult = new HashMap<>();

        final int numberOfPoints = users.size();
        IntStream.range(0, numberOfPoints)
                .forEach(pointIndex -> userToResult.put(users.get(pointIndex), results.get(followLadder(pointIndex))));

        return userToResult;
    }

    private int followLadder(int pointIndex) {
        for (Line line : lines) {
            pointIndex = getNextPointIndex(pointIndex, line);
        }

        return pointIndex;
    }

    private int getNextPointIndex(int pointIndex, Line line) {
        final int beforeBridgeIndex = pointIndex - 1;
        final int nextBridgeIndex = pointIndex;

        if (beforeBridgeIndex >= 0 && line.hasBridge(beforeBridgeIndex)) {
            return --pointIndex;
        }

        if (nextBridgeIndex < line.getLength() && line.hasBridge(nextBridgeIndex)) {
            return ++pointIndex;
        }

        return pointIndex;
    }

}
