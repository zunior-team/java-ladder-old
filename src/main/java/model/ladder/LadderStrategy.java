package model.ladder;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LadderStrategy {

    private static Random RANDOM = new Random();
    private final Integer height;
    private final Double lineProbability;

    private LadderStrategy(final Integer height, final Double lineProbability){
        this.height = height;
        this.lineProbability = lineProbability;
    }

    public static LadderStrategy newInstance(final Integer height, final Double lineProbability){
        return new LadderStrategy(height, lineProbability);
    }

    public int getHeight(){
        return height;
    }

    public boolean isLineCreatable(){
        return (lineProbability >= ThreadLocalRandom.current().nextDouble(0, 1));
    }
}
