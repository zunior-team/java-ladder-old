package ladder.domain;

import java.util.Random;

import static ladder.constant.LadderConstants.LADDER_HEIGHT_PERCENTAGE_MAX;

public class PointCreator {

    private PointCreator(){}

    private static Random random = new Random(System.currentTimeMillis());

    public static boolean createRandomPoint(){
        return random.nextBoolean();
    }
    public static boolean createRandomPointByPercentage(int percentage){
        return random.nextInt(LADDER_HEIGHT_PERCENTAGE_MAX) < percentage;
    }
}
