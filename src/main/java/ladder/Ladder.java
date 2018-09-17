package ladder;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<Line> lines;

    public Ladder(int ladderHeight, int countOfFoothold) {
        lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(countOfFoothold));
        }
    }

    public ArrayList<Line> getLines(){
        return this.lines;
    }


}
