package ladder.domain;

import java.util.ArrayList;

public class LadderSetting {

    private int row;
    ArrayList<String> names;

    public LadderSetting (int row, ArrayList<String> names) {
        this.row = row;
        this.names = names;
    }

    public ArrayList<Line> makeAllLine() {
        ArrayList<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < row; i++) {
            Line line = new Line(names.size()-1);
            lines.add(line);
        }
        return lines;
    }
}


