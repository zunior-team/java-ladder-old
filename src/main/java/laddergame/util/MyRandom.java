package laddergame.util;

import java.util.Random;

public class MyRandom {
    private static Random random = new Random();

    public static boolean nextBoolean(){
        return random.nextBoolean();
    }
}
