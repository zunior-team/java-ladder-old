package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private List<Line> ladder;

    public Ladder(int n, int height) {
        this.ladder = makeLadder(n, height);
    }

    public List<Line> makeLadder(int length, int height) {
        List<Line> ladder = new ArrayList<Line>();

        for (int i = 0; i < height; i++) {
            ladder.add(new Line(length));
        }
        return ladder;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(this.ladder);
    }

    public int runGame(int searchIdx) {
        int resultIdx = searchIdx;

        for (Line line : this.ladder) {
            resultIdx = line.move(resultIdx);
        }
        return resultIdx;
    }
}
