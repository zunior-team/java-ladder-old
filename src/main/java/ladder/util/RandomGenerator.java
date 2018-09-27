package ladder.util;

import java.util.Random;

public class RandomGenerator {
    private static final int ZERO = 0;
    private static final int RANDOM_BOUND = 2;
    private static Random rnd = new Random();

    // Create boolean from randomValue
    public static boolean generateRandomBool(){
        return rnd.nextInt(RANDOM_BOUND) != ZERO;
    }
}
