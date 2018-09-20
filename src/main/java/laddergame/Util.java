package laddergame;

import java.util.Random;

public class Util {
    private static final int RANGE = 9;

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANGE);
    }
}
