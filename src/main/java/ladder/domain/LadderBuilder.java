package ladder.domain;

import java.util.ArrayList;

public class LadderBuilder {

    private static ArrayList<LadderLine> ladderLines;

    public static ArrayList<LadderLine> drawLadderLines(String[] names, int height) {
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


