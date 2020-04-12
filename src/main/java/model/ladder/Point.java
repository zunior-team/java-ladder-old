package model.ladder;

import java.util.Random;

public class Point {

    public static final PointState[] STATES = {PointState.DASH, PointState.SPACE};
    private static final Random random = new Random();
    private final int currentPoint;
    private final PointState state;

    public Point(PointState state) {
        this(state, -1);
    }

    public Point(PointState state, int currentPoint) {
        this.state = state;
        this.currentPoint = currentPoint;
    }

    public boolean isDash(){
        return (state == PointState.DASH);
    }

    public boolean isBar(){
        return (state == PointState.BAR);
    }

    public boolean isMyStartPoint(int currentPoint){
        return (this.currentPoint == currentPoint);
    }

    public String getDisplay(){
        return state.display();
    }

    public static PointState generateStateByRandom(){
        return Point.STATES[random.nextInt(STATES.length)];
    }
}
