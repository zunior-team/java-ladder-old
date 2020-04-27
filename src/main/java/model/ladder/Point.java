package model.ladder;

import java.util.Random;

public class Point {

    public static final PointState[] STATES = {PointState.DASH, PointState.SPACE};
    private static final Random random = new Random();
    private final PointState state;

    public Point(PointState state) {
        this.state = state;
    }

    public boolean isDash(){
        return (state.isDash());
    }

    public String getDisplay(){
        return state.display();
    }

    public static PointState generateStateByRandom(){
        return Point.STATES[random.nextInt(STATES.length)];
    }
}
