package laddergame.domain;

import laddergame.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private List<Position> line;

    // test용 생성자
    public Line() {
        this.line = new ArrayList<>();
    }

    public Line(int length) {
        this.line = new ArrayList<>();
        makeLine(length, RandomGenerator.makeRandNum(length));
    }

    public void makeLine(int length, int horizonIdx) {
        for (int i = 0; i < length; i++) {
            this.line.add(new Position(i, horizonIdx, length));
        }
    }

    public List<Position> getLine() {
        return Collections.unmodifiableList(this.line);
    }

    public int move(int idx) {
        Position p = this.line.get(idx); // 포지션
        return p.move(idx);
    }

}
