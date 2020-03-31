package com.zuniorteam.ladder.core;

import java.util.List;

public class Line {

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        assert points != null;

        this.points = points;
    }

    public int getLength() {
        return points.size();
    }

    public Boolean hasBridge(int index) {
        if (index <= 0) {
            return false;
        }

        return this.points.get(index - 1) && this.points.get(index);
    }
}
