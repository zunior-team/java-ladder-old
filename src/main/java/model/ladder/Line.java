package model.ladder;

public class Line {

    private State state = State.NONE;
    private int row;
    private int col;

    public Line(){}

    public static Line of(int currentHeight) {
        return new Line();
    }

    enum State{
        BAR, LINE, NONE
    }
}
