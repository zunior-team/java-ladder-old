package model.ladder;

public class Point {

    private State state = State.NONE;
    private int row;
    private int col;

    enum State{
        BAR, LINE, NONE
    }
}
