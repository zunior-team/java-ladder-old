package com.zuniorteam.ladder.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validate(points);

        this.points = new ArrayList<>(points);
    }

    private void validate(List<Boolean> points) {
        assert points != null;

        IntStream.range(0, points.size())
                .forEach(i -> validateContinuesBridge(points, i));
    }

    private void validateContinuesBridge(List<Boolean> points, int index) {
        if (index < 2) {
            return;
        }

        if (points.get(index)
                && points.get(index - 1)
                && points.get(index - 2)) {
            throw new IllegalArgumentException("이어지는 bridge를 만들 수 없습니다.");
        }
    }

    public int getLength() {
        return points.size();
    }

    public Boolean hasBridge(int index) {
        if (index < 1) {
            return false;
        }

        return this.points.get(index - 1) && this.points.get(index);
    }
}
