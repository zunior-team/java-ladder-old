package model.ladder;

import java.util.Random;

public class Point {

    private static final Random random = new Random();
    private static final State[] STATES = {State.LINE, State.SPACE};
    private final State state;

    public Point(State state) {
        this.state = state;
    }

    enum State{
        BAR("|"), LINE("-"), SPACE(" ");
        private String display;
        State(String display){
            this.display = display;
        }
    }

    public boolean isLine(){
        return (state == State.LINE);
    }

    public String getDisplay(){
        return state.display;
    }

    public static State generateStateByRandom(){
        return STATES[random.nextInt(2)];
    }
}
