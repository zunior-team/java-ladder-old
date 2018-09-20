package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    public static final boolean ABLE = true;
    public static final boolean UNABLE = false;

    private List<Boolean> line;

    public Line(int length) {
        this.line = new ArrayList<>();
        makeLine(length);
    }

    public void makeLine(int length) {
        for (int i = 0; i < length - 1; i++) {
            this.line.add(checkHorizon(randAble(), line));
        }
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(this.line);
    }

    public static boolean randAble() {
        return (Math.random() < 0.5) ? UNABLE : ABLE;
    }

    public static boolean checkHorizon(boolean randAble, List<Boolean> line) {
        if (randAble == ABLE && !(line.contains(true))) { // randNum이 1이고 이미 가로선을 가지고 있으면 가로를 채운다.
            return true;
        }
        return false;
    }

}
