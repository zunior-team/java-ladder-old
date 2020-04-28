package com.zuniorteam.ladder.core;

import com.zuniorteam.ladder.core.util.CollectionUtil;

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
        if (CollectionUtil.isFirstIndex(index)) {
            return;
        }

        if (bridges.get(index) && CollectionUtil.getBefore(bridges, index)) {
            throw new IllegalArgumentException("이어지는 bridge 를 만들 수 없습니다.");
        }
    }

    public int getLength() {
        return bridges.size();
    }

    public boolean hasBridge(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("bridge 위치는 0보다 작을 수 없습니다.");
        }

        return this.bridges.get(index);
    }

    public boolean hasLeftBridge(int index) {
        int leftIndex = index - 1;

        if (leftIndex < 0) {
            return false;
        }

        return this.bridges.get(leftIndex);
    }

    public boolean hasRightBridge(int index) {
        int rightIndex = index;

        if(rightIndex < this.bridges.size()){
            return this.bridges.get(rightIndex);
        }

        return false;
    }
}
