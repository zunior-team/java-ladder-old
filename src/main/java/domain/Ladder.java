package domain;

import java.util.ArrayList;

public class Ladder {
    private static ArrayList<LadderLine> ladderLines;

    public static ArrayList<LadderLine> makeLadderLines(String[] names, int height) {
        ladderLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderLines.add(LadderLine.init(names.length));
        }
        return ladderLines;
    }

    public static ArrayList<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
