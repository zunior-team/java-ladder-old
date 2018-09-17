package ladder.domian;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private ArrayList<Line> lines;

    Ladder(int ladderHeight, int countOfFoothold) {
        lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(countOfFoothold));
        }
    }

    public List<Line> getLines(){
        return this.lines;
    }
}
