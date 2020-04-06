package com.zuniorteam.ladder.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> bridges;

    public Line(List<Boolean> bridges) {
        validate(bridges);

        this.bridges = new ArrayList<>(bridges);
    }

    private void validate(List<Boolean> bridges) {
        assert bridges != null;

        IntStream.range(0, bridges.size())
                .forEach(i -> validateContinuesBridge(bridges, i));
    }

    private void validateContinuesBridge(List<Boolean> bridges, int index) {
        if (index < 1) {
            return;
        }

        if (bridges.get(index)
                && bridges.get(index - 1)) {
            throw new IllegalArgumentException("이어지는 bridge를 만들 수 없습니다.");
        }
    }

    public int getLength() {
        return bridges.size();
    }

    public Boolean hasBridge(int index) {
        return this.bridges.get(index);
    }
}
