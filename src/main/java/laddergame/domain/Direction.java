package laddergame.domain;

public class Direction {

    public static final int NONE = 0; // 방향 없음
    public static final int LEFT = 1; // 왼쪽으로 이동
    public static final int RIGHT = 2; // 오른쪽으로 이동

    private int direction;

    public Direction(int direction) {
        this.direction = direction;
    }

    public Boolean isLeft() { return this.direction == LEFT; }

    public Boolean isRight() {
        return this.direction == RIGHT;
    }

}
