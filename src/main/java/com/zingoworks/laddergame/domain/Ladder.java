package com.zingoworks.laddergame.domain;

import java.util.Random;

public class Ladder {
    public Boolean[] ladderValue;
    public int numOfPeople;

    Random random = new Random();

    public Ladder (int numOfPeople) {
        this.numOfPeople = numOfPeople;
        ladderValue = new Boolean[numOfPeople - 1];
        makeLadder();
    }

    public void makeLadder () {
        for (int i = 0; i < numOfPeople - 1; i++) {
            ladderValue[i] = random.nextBoolean();
        }
    }

    public Ladder[] makeLadders (int maxLadderHeight) {
        Ladder[] ladders = new Ladder[maxLadderHeight];
        for (int i = 0; i < maxLadderHeight; i++) {
            ladders[i] = new Ladder(this.numOfPeople);
        }
        return ladders;
    }
}
