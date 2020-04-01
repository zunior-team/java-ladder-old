package ladder.domain;

import java.util.Random;

public class PointCreator {

    private PointCreator(){}

    private static Random random = new Random(System.currentTimeMillis());

    public static boolean createRandomPoint(){
        return random.nextBoolean();
    }
}
