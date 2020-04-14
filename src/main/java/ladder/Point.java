package ladder;

public class Point {
    private int index;
    private Direction direction;

    public int move() {
        return direction.move(index);
    }
}
