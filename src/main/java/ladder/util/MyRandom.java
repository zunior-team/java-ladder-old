package ladder.util;

import java.util.Random;

public class MyRandom {
    private static final int RANDOM_BOUND = 100;
    private static final int MOVE_POSSIBILITY = 40;
    private static Random rnd = new Random();

    public static boolean get(){
        return rnd.nextInt(RANDOM_BOUND) > MOVE_POSSIBILITY;
    }
}
