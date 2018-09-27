package laddergame.util;

import java.util.Random;

public class RandomGenerator {

    public static int makeRandNum(int i) {
        Random rand = new Random();
        return rand.nextInt(i);
    }
}
