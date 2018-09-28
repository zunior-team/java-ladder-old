package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines;

    public Ladder(int width, int height) {
        lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width));
        }
    }

    public void makeLadder() {
        for (Line line : lines) {
            line.makeLine();
        }
    }

    public Line getLine(int index) {
        return lines.get(index);
    }

    public int size(){
        return lines.size();
    }

    public void getFinalNamePosition(List<String> names) {
        for (Line line : lines) {
            line.swap(names);
        }
    }
}
