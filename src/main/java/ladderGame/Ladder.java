package ladderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final int RANDOM_BOUND = 2;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private static Random rnd = new Random();
    private List<Integer> lines = new ArrayList<>();;

    // Add line(0,1) to lines
    public void makeLine(){
        this.lines.add(this.generateValidLine());
    }

    // Don't overlap with line
    public int generateValidLine(){
        int size = lines.size();
        if(size > ZERO){
            return lines.get(size - ONE) == ONE ? ZERO : generateRandom();
        }
        return generateRandom();
    }

    public List<Integer> getLines() {
        return this.lines;
    }

    // Create randomValue(0,1)
    public static int generateRandom(){
        return rnd.nextInt(RANDOM_BOUND);
    }
}
