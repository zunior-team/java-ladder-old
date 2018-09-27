package laddergame.util;

import java.util.Random;

public class Util {
    public static final int RANGE = 9;
    public static final String COMMA = ",";

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANGE);
    }
}
