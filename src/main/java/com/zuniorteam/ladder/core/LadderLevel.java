package com.zuniorteam.ladder.core;

import com.zuniorteam.ladder.core.util.MathUtil;

public enum LadderLevel {

    HIGH(LadderHeightConstants.LADDER_HEIGHT_HIGH, Complexity.COMPLEXITY_HIGH),
    MEDIUM(LadderHeightConstants.LADDER_HEIGHT_MEDIUM, Complexity.COMPLEXITY_MEDIUM),
    LOW(LadderHeightConstants.LADDER_HEIGHT_LOW, Complexity.COMPLEXITY_LOW);

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

    private static class LadderHeightConstants {
        private static final int LADDER_HEIGHT_HIGH = 20;
        private static final int LADDER_HEIGHT_MEDIUM = 10;
        private static final int LADDER_HEIGHT_LOW = 5;
    }

    private static class Complexity {
        private static final int COMPLEXITY_HIGH = 70;
        private static final int COMPLEXITY_MEDIUM = 50;
        private static final int COMPLEXITY_LOW = 30;
    }
}
