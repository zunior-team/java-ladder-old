package com.zuniorteam.ladder.core;

import com.zuniorteam.ladder.core.util.MathUtil;

public enum LadderLevel {


    HIGH(20, 70),
    MEDIUM(10, 50),
    LOW(5, 30);

    private static final int MAX_COMPLEXITY = 100;

    private final int ladderHeight;
    private final int complexity;

    LadderLevel(int ladderHeight, int complexity) {
        this.ladderHeight = ladderHeight;
        this.complexity = complexity;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public double getPercentOfBuildBridge() {
        return MathUtil.divide(complexity, MAX_COMPLEXITY);
    }


}
