package ladderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final int RANDOM_BOUND = 2;
    private static final int ZERO = 0;
    private static final String SPACE = " ";
    private static final String HYPHEN = "-";
    private static Random rnd = new Random();

    private List<String> lines = new ArrayList<>();;

    public void makeLine(){
        this.lines.add(decideLine());
    }

    public List<String> getLines() {
        return this.lines;
    }

    private static String decideLine(){
        int randomValue = rnd.nextInt(RANDOM_BOUND);
        return (randomValue == ZERO) ? SPACE : HYPHEN;
    }
}
