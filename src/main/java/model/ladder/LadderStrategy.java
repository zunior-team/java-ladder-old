package model.ladder;

import java.util.concurrent.ThreadLocalRandom;

public class LadderStrategy {
    private final int height;
    private final double lineProbability;

    private LadderStrategy(final int height, final double lineProbability){
        this.height = height;
        this.lineProbability = lineProbability;
    }

    public static LadderStrategy newInstance(final int height, final double lineProbability){
        return new LadderStrategy(height, lineProbability);
    }

    public int getHeight(){
        return height;
    }

    public boolean isLineCreatable(){
        return (lineProbability >= ThreadLocalRandom.current().nextDouble(0, 1));
    }
}
