package laddergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    static final int HORIZONTAL = 2; // 가로
    static final int VERTICAL = 1; // 세로
    static final int NONE = 0;

    private List<Integer> line;

    public Line(int length) {
        this.line = new ArrayList<Integer>();
        makeLine(length);
    }

    public void makeLine(int length) {
        for (int i = 0; i < length; i++) {
            this.line.add(checkLine(i, line));
        }
    }

    public List<Integer> getLine() {
        return Collections.unmodifiableList(this.line);
    }

    public static int randNum() {
        return (Math.random() < 0.5) ? NONE : VERTICAL;
    }

    public static int checkHorizon(int randNum, List<Integer> line) {
        if (randNum == VERTICAL && !(line.contains(HORIZONTAL))) { // randNum이 1이고 이미 가로선을 가지고 있으면 가로를 채운다.
            return HORIZONTAL;
        }
        return NONE;
    }

    public static int checkLine(int i, List<Integer> line) {
        if (i % 2 == NONE) {
            return VERTICAL;
        }
        return checkHorizon(randNum(), line);
    }

}
