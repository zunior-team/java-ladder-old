package com.zuniorteam.ladder.core;

import com.zuniorteam.ladder.core.util.CollectionUtils;

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
        if (CollectionUtils.isFirstIndex(index)) {
            return;
        }

        if (bridges.get(index) && CollectionUtils.getBefore(bridges, index)) {
            throw new IllegalArgumentException("이어지는 bridge 를 만들 수 없습니다.");
        }
    }

    public int getLength() {
        return bridges.size();
    }

    public Boolean hasBridge(int index) {
        if(index < 0){
            throw new IllegalArgumentException("bridge 위치는 0보다 작을 수 없습니다.");
        }

        return this.bridges.get(index);
    }
}
