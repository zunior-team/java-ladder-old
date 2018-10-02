package laddergame.domain;

import java.util.ArrayList;

import static laddergame.util.Util.MOVE_LEFT;
import static laddergame.util.Util.MOVE_RIGHT;

public class Player {
    private String name;
    private int index;

    public Player(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    private void moveRight(boolean isRight) {
        if (isRight) {
            this.index += MOVE_RIGHT;
        }
    }

    private void moveLeft(boolean isLeft) {
        if (isLeft) {
            this.index += MOVE_LEFT;
        }
    }

    private void move(boolean isLeft, boolean isRight) {
        moveLeft(isLeft);
        moveRight(isRight);
    }

    public void move(ArrayList<Boolean> points) {
        if (isFirst()) {
            move(false, points.get(index));
        } else if (isLast(points)) {
           move(points.get(index - 1), false);
        } else if (isMeddle(points)) {
            move(points.get(index-1), points.get(index));
        }
    }

    private boolean isMeddle(ArrayList<Boolean> points) {
        return index < points.size();
    }

    private boolean isLast(ArrayList<Boolean> points) {
        return index == points.size();
    }

    private boolean isFirst() {
        return index == 0;
    }
}
