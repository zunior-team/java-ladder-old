package laddergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private List<Line> ladder;

    public Ladder(int n, int height) {
        this.ladder = makeLadder(2 * n - 1, height);
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
}
