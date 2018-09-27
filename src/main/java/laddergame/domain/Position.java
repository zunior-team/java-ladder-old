package laddergame.domain;

public class Position {

    private Direction direction;

    public Position(int idx, int horizonIdx, int length) {
        this.direction = makeDirection(idx, horizonIdx, length - 1);
    }

    public static Direction makeDirection(int idx, int horizonIdx, int lastIdx) {
        if (idx == horizonIdx || idx == horizonIdx + 1) {
            return new Direction(hasDirection(idx, horizonIdx, lastIdx));
        }
        return new Direction(Direction.NONE);
    }

    public Direction getDirection() {
        return this.direction;
    }

    // horizonIdx가 마지막 idx와 값이 같으면 무조건 NONE이 나오게
    public static int hasDirection(int idx, int horizonIdx, int lastIdx) {
        if (horizonIdx == lastIdx) {
            return Direction.NONE;
        }
        return checkLorR(idx, horizonIdx);
    }

    public static int checkLorR(int idx, int horizonIdx) {
        if (idx == horizonIdx + 1) {
            return Direction.LEFT;
        }
        return Direction.RIGHT;
    }

    public int move(int idx) {
        if (this.direction.isRight())
            return idx + 1;
        if (this.direction.isLeft())
            return idx - 1;
        return idx;
    }

}
