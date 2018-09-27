package ladder.domain;

import ladder.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private List<Boolean> lines;

    public Line() {
        this.lines = new ArrayList<>();
    }

    // for unit test.
    public Line(List<Boolean> lines) {
        this.lines = lines;
    }

    public void addLine(){
        this.lines.add(this.generateValidLine());
    }

    public boolean generateValidLine(){
        int size = lines.size();
        if(size > ZERO){
            return lines.get(size - ONE) ? false : RandomGenerator.generateRandomBool();
        }
        return RandomGenerator.generateRandomBool();
    }

    // decide left or right or just down
    public int decideMove(int location){
        if(isLeft(location)){
            return location - ONE;
        }
        if(isRight(location)){
            return location + ONE;
        }
        return location;
    }

    public boolean isLeft(int location){
        if(isLeftSide(location)){
            return false;
        }
        return this.lines.get(location - ONE);
    }

    public boolean isRight(int location){
        if(isRightSide(location)){
            return false;
        }
        return this.lines.get(location);
    }

    public boolean isLeftSide(int location){
        return location == ZERO;
    }

    public boolean isRightSide(int location){
        return location == this.lines.size();
    }

    public List<Boolean> getLines() {
        return lines;
    }
}
